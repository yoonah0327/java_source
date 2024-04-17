package pack4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31myDtoTest {
	ArrayList<Ex31myDto> list = new ArrayList<Ex31myDto>();
	Ex31myDto stu;

	public void inserScanner() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("이름 입력 :");
				String name = sc.next();
				System.out.print("국어 점수 :");
				int kor = sc.nextInt();
				System.out.print("영어 점수 :");
				int eng = sc.nextInt();

//			stu = new Ex31myDto(name, kor, eng);
//			list.add(stu);

				Ex31myDto dto = new Ex31myDto();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				list.add(dto);

				System.out.println("계속할까요?(y/n): ");
				if (sc.next().equalsIgnoreCase("n"))
					break;
			} catch (Exception e) {
				System.out.println("처리 중 오류 발생");
				break;
			}
		}
	}

	public void showList() {
		System.out.println("이름 국어 영어 총점");
		for (Ex31myDto d : list) {
			System.out.println(d.getName() + " " + d.getKor() + " " + d.getEng() +" " + (d.getKor()+d.getEng()));
		}
		System.out.printf("응시인원 %d명", list.size());
	}

	public static void main(String[] args) {
		Ex31myDtoTest dto = new Ex31myDtoTest();
		dto.inserScanner();
		dto.showList();
	}
}
