package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Net4TestServer {

	public static void main(String[] args) {
		// 단순 서버 
		ServerSocket ss = null;
		
		// 내컴퓨터가 사용중인 port number 확인
		/*for (int i = 0; i < 65536; i++) {
			try {
				ss= new ServerSocket(i);
				ss.close();
			} catch (Exception e) {
				System.out.println(i + "번 port는 사용 중");
			}
		}
			System.out.println("확인 종료"); // 이미 쓰고있는 포트들 확인할수있다. 이외의 포트번호를 사용해야함.
		// taskkill 을 통해 프로세스 강제 종료
		  */
		
		Socket socket = null; // tcp 기반의 통신용 클래스(파일)
		try {
			ss = new ServerSocket(9999); // 서버소켓
			System.out.println("서버 service srt..");
			socket= ss.accept(); // 서버 소켓으로부터 클라이언트컴과 통신하기위한 개별소켓만들기
		// 이 accept때문에 무한루프에 빠진다. 클라이언트가 접속하기전까지 기다린다. 
			
			BufferedReader reader= new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)); // 자료를 받음. 한글깨짐방지용으로 뒷쪽에 standardcharset추가함
		String data = reader.readLine(); // 정보를 받고 
		System.out.println("수신 data: "+ data);
		
		reader.close();
		socket.close();
		ss.close(); // 받고 닫는다 
		
		} catch (Exception e) {
			System.out.println("server err:"+e);
		}
		 
	}

	}


