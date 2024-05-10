package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


// Echo Server: 클라이언트의 요청에 계속 반응을 보이는 서버

public class Net5EchoServer {
	ServerSocket ss;
	Socket socket;
	PrintWriter out;
	BufferedReader reader;
	
	public Net5EchoServer() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 서비스 중..");
			
			socket = ss.accept(); // 클라이언트와 접속대기. 접속하면 socket객체생성.
			
			out = new PrintWriter( // out객체 생성. 내보낼 내용
					new OutputStreamWriter(
							socket.getOutputStream(), StandardCharsets.UTF_8), true);
			reader = new BufferedReader( // reader 객체. 읽어올내용. 클라이언트로부터 받아올.
					new InputStreamReader(
							socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (Exception e) {
			System.out.println("Net5EchoServer err:" +e);
			System.exit(0);
		}
		
	}
	
	public void receivedSendData() {
		try {
			String msg = reader.readLine(); // 클라이언트 자료수신
			System.out.println("수신된 메시지:"+ msg);
			
			out.println("서버가 보낸 메시지:"+ msg+ "잘 봤다"); // 받은자료 전송
		} catch (Exception e) {
			System.out.println("receivedSendData err:" +e);
		} finally {
			try {
			reader.close(); 
			out.close(); 
			socket.close();
			ss.close(); // 	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		while(true) { //무한루프에 빠뜨리기
		Net5EchoServer server = new Net5EchoServer(); // server 객체생성
		server.receivedSendData();
		}

	}

}
