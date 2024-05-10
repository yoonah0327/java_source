package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		// 특정컴 접속후 메세지 전달하기
		try {
			//InetAddress ia = InetAddress.getByName("127.0.0.1");
			//System.out.println(ia);
			//명령프롬프트에서 ip주소확인하는명령어: ipconfig. 모든걸 보고싶다면 뒤에 /all.
			
			Socket socket = new Socket("192.168.0.31", 9999); // 서버와접속. 내 ip주소, 비사용포트번호 // 강남구역삼동, 1번지 이거랑 같다.
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);
			writer.println("good morning입니다"+ "\n"); // 서버에 자료전송
			
			writer.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("clinet err:"+ e);
		}

	}

}
