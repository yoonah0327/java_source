package pack1;

import java.time.LocalDate;

public class Ex8Main {

	public static void main(String[] args) {
		// 싱글톤 패턴 연습
		Ex8SingletoneClass s1 = new Ex8SingletoneClass();
		System.out.println(s1.kor);

		Ex8SingletoneClass s2 = new Ex8SingletoneClass();
		System.out.println(s2.kor);

		System.out.println(s1 + " " + s2);
		System.out.println(s1.hashCode() + " " + s2.hashCode());

		System.out.println("--------------");
		Ex8SingletoneClass s3 = Ex8SingletoneClass.getInstance(); 
		//위와 다르게 static을 이용해서 new 없이. 스태틱 사용했기에, 바로 부를수있다. 스태틱특성상 heap에 저장된것이 아니기에 주소를 참조하여 자원의효율성 추구가. 
		
		System.out.println(s3.kor);  
		
		Ex8SingletoneClass s4 = Ex8SingletoneClass.getInstance();
		System.out.println(s4.kor); 
		
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		
		System.out.println("날짜 출력 싱글통 사용 예");
		LocalDate mynow = LocalDate.now(); 
		LocalDate mynow2 = LocalDate.now(); 
		System.out.println(mynow.hashCode() + " " + mynow2.hashCode());
		System.out.println(mynow2.getYear());
		
		
		
	}

}
