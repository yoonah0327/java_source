package pack4;

import java.io.FileNotFoundException;
import java.io.FileReader;

// 예외처리 : 키보드, 파일처리, 네트워크, DB연동처리 등 외부와 접속을 통한프로그래밍작업중 
// 예상치못한 에러발생 할수 있다. 이와 같은 경우에 주로 사용.
// try ~ catch 구문을 사용한다.
public class Ex26Try {

	public void testMethod() {
		System.out.println("testMethod");
		try {
			int a[] = { 1, 2, 3 };
			System.out.println("배열 요소 값 출력:" + a[0]);
			System.out.println("배열 요소 값 출력:" + a[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("testMethod 오류 :" + e);
		}

	}

	public static void main(String[] args) {
		try {
			// 보조기억장치의 파일읽기
			FileReader fr = new FileReader("c:/work/aa.txt");
			// 객체가 인스턴스의 주소를 갖지 않은경우
			// Ex26Try try1 = null;
			Ex26Try try1 = new Ex26Try();
			try1.testMethod();

			int re = 10/ 0;
			System.out.println("re : "+ re);
			
//		} catch (FileNotFoundException e1) {
//			System.out.println("해당 파일이 없어요");
//		} catch (NullPointerException e2) {
//			// e2.printStackTrace();
//			System.out.println("객체변수에러 원인은 " + e2.getMessage());
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("배열처리 중 에러:" + e);
		} catch (Exception e ) {
			System.out.println("오류 " + e);
		} finally {
			System.out.println("에러와 상관없이 반드시 출력");
		}

		System.out.println("프로그램 종료");
	}

}
