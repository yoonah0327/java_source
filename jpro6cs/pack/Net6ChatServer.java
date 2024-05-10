package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// polling pool

// 멀티 채팅 서버: Thread + Socket
public class Net6ChatServer {
	private static final int PORT = 5000;
	// private static List<Socket> clients = new ArrayList<Socket>(); //스레드에 더 최적화된
	// 어레이가 있음.
	// CopyOnWriteArrayList. : 컨텐츠를 읽어 어딘가에 전달할때 컨텐츠를 복사해서 전달함. 스레드에서 안심하고 처리가.
	private static List<Socket> clients = new CopyOnWriteArrayList<Socket>();

	// ExecutorService를 이용하면 Thread pool을 생성해 병렬처리가. 안그러면, 거의동시에 들어올때 그중에 한명은
	// 기다릴수있다.
	private static ExecutorService pool = Executors.newFixedThreadPool(4); // 적당히만들자. 상황에따라 가감. 딱 접수원서시즌.

	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(PORT);
		System.out.println("채팅 서버 서비스 시작..");

		try {
			while (true) { // 무한루프상태에 빠지게 하기.
				Socket clientSocket = serversocket.accept(); // 누군가접속하면 ClientSocket하나 만든다.
				System.out.println("새 접속자와 연결: " + clientSocket.getInetAddress()); // 클라이언트주소확인
				clients.add(clientSocket); // 받아서 상단 어레이리스트에 담기
				
				pool.execute(new ClientHandler(clientSocket)); // 스레드pool 객체가 스레드를 실행

			}
		} finally {
			serversocket.close();
		}

	}

	static class ClientHandler implements Runnable {
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		public ClientHandler(Socket socket) throws IOException {
			this.socket = socket; // 접속하는 사람수대로 소켓이만들어짐
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // in, out 객체 인스턴스
			out = new PrintWriter(socket.getOutputStream(), true); // true는 내보내고 청소하는것
		}

		@Override
		public void run() {
			try {
				String name = in.readLine(); // 접속자명 받기
				if (name == null) {
					throw new IOException("클라이언트 연결이 끊어졌다");
				}
				System.out.println(name + "님 접속했다");
				broadcastMessage("^^;" + name + "님 입장 ^^;");
				
				String message; //메시지 넘어옴
				while((message = in.readLine()) != null) { // 메시지 수신
					broadcastMessage(name+ "님 메시지:" + message); //접속자모두에게 한 클라이언트에게 받은 자료 보내기 
					
				}
				
			} catch (Exception e) {
				System.out.println("접속자 연결 오류: " + e.getMessage());
			} finally {
				try {
					if (socket != null) {
						socket.close();
						clients.remove(socket);

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}
		
		private void broadcastMessage(String message) {
			for(Socket client: clients) {
				try {
					if(!client.isClosed()) { // 클라이언트로 송신할 데이터를 위한 PrintWriter객체를 생성해 송신후 자동으로 flush
						PrintWriter clientOut = new PrintWriter(client.getOutputStream(), true); // true: flush. 자료비움
						clientOut.println(message);
					}
				} catch (Exception e) {
					System.out.println("broadcastMessage err:" + e.getMessage());
				}
			}
		}

	}
}
