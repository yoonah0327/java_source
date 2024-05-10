package pack;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

// URL 클래스로 특정 웹서버 컴의 문서 읽기
// 서버들의 자원의 접근하여 주소 및 기타정보를 다루는 클래스 
public class Net1URL {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net"); // https://www.naver.com:80/index.html 
			// http보안용 서버=> https. tcp프로토콜 기반 응용프로그램 계층에서 사용
			// 80과 index.html모두 생략가. 
			InputStream is = url.openStream(); // 사이트의 자료를 읽어옴
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//System.out.println(br.read());
			
			// 읽은 문서 출력 및 저장 
			PrintWriter pw = new PrintWriter(System.out, true);
			PrintWriter fw = new PrintWriter(new FileOutputStream("c:/work/ok.html"));			
			
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line); // 콘솔로 출력
				fw.println(line); // file로 저장
				fw.flush(); // 
				
			}
			br.close();
			is.close();
			pw.close();
			fw.close();
			
		} catch (Exception e) {
			System.out.println("err: "+ e);
		}
		// TODO Auto-generated method stub

	}

}
