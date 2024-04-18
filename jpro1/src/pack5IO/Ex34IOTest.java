package pack5IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex34IOTest {
	// Console과 file을 통한 입력
	public static void main(String[] args) throws Exception {
		// 1. Console을 통한 입력
//	InputStreamReader in =new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
//		System.out.println("이름은");
//		String ir = br.readLine();
//		System.out.println("이름은 " + ir);
//		br.close();
//		in.close();
//		 요즘엔 이 방법은 잘 쓰지 않는다.

		// 2. Scanner를 통한 입력
//	Scanner scanner = new Scanner(System.in);
//	System.out.print("이름은");
//	String ir = scanner.nextLine();
//	System.out.print("몸무게는");
//	double w= scanner.nextDouble();
//	System.out.println(ir+ "님의 몸무게는 " + w);
//	Scanner.close();

		// 파일읽기
 // 메모장에 저장된 내용읽어 출력하기
		// File f = new File("c:/work/good.txt"); 이게 기본모양
		File f = new File("c:\\work\\good.txt"); // 윈도우에선 백슬래시두개로.
		// 문자단위
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr); // 완충장치
		// System.out.println(br.readLine());// read는 다읽기 readline은 한줄씩
		while (true) { // 어디까지가 끝이지 모르니 무한루프돌게해주기
			String ss = br.readLine();
			if (ss == null)
				break;
			System.out.println(ss);
		}
		br.close(); // Garbage collector(GC)로 하여금 점유 메모리 해제 요청
		fr.close();
// 데이터를 받아 읽어 출력하기
		System.out.println();
		File file = new File("c:/work/전국도서관표준데이터.csv");
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);
		int count = 0;
		String ss = br2.readLine(); // 첫문장인 "도서관명.." 이 부분을 건너뛰기 위해 이 문장을 넣어줌.
		while (true) {
			count++;
			ss = br2.readLine();
			if (ss == null || count >= 10)
				break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();

			System.out.println(s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);
		}
		System.out.println("건수: " + count);
	}
}
