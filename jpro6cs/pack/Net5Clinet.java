package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Net5Clinet {
	Socket socket;
	PrintWriter out;
	BufferedReader reader;

	public Net5Clinet() {
		try {
			socket = new Socket("192.168.0.31", 8888);

			out = new PrintWriter( // out객체 생성. 내보낼 내용
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			reader = new BufferedReader( // reader 객체. 읽어올내용. 클라이언트로부터 받아올.
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
		} catch (Exception e) {
			System.out.println("Net5Client err:" + e);
		}
	}

	public void sendRecievedData() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("전송 메시지 입력:");
			String data = scanner.nextLine();
			out.println(data); // 서버로 전송
			// 이때 서버가 받아서 자료읽고, 자료잘받았다고 또 날림.
			String re_data = reader.readLine(); // 서버가 보낸 자료수신
			System.out.println("수신된 자료는 " + re_data);
		} catch (Exception e) {
			System.out.println("sendReceivedData err:" + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
			} catch (Exception e2) {
				
			}
		}
	}

	public static void main(String[] args) {
		Net5Clinet client = new Net5Clinet();
		client.sendRecievedData();

	}

}
