package pack;

import java.util.Scanner;

public class Test7For {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기치;조건;증감치){반복처리대상}-------------------------------------
		int a;
		// for(int a = 1; a <=5; a = a+1) { 
		// 프로그램을 짤때 unit 단위로 빼고넣을수 있도록 생각해서 짜기.
		// 이렇게 for 문 안에 int 넣어주면 블럭화되는것. 밖에 int 선언해주고, syso 해주면 연결되어버림.
		// for(a = 1; a <=5; a = a+1) {
		// for(a = 1; a <=5; a += 1) {

		int sum = 0; // 누적기억장소

		for (a = 1; a <= 10; a++) {
			System.out.println("a : " + a);
			// a=4; for문()안에서만 조건문만 건들자. 굳이 또 변수값 만들기하지말기.
			sum += a;

		}
		System.out.println("반복문 수행 후 a :" + a);
		System.out.println("합은 " + sum);

		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 10; i > 1; i -= 2) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int ytn = 0, tvn = 5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + " " + tvn + ":"); // ok 보통 이렇게 두개는 안함.
		}

		System.out.println();
		int aa = 1;
		for (; aa <= 5; aa++) {
			System.out.print(aa + " "); // ok 보통 이렇게는 안함.
		}

		System.out.println("\n\n다중 for ---------------");
		for (int m = 1; m <= 3; m++) {
			System.out.println("m=" + m);
			for (int n = 1; n <= 4; n++) {
				System.out.print("n :" + n + " ");
			}
			System.out.println(); // 블럭은 블럭안에 들어갈수 있다. 병행만 안될뿐. 
			// 밖 for는 3번수행. 안 for는 4 *3(밖for의 영향) 12번수행
		}
		System.out.println();
		for (char i = 65; i <= 90; i++) {
			System.out.print(i + " : ");
			for (char j = i; j <= 'Z'; j++) {
				System.out.print(j);
			}
		}
		System.out.println();
		// 구구단 3단 출력
		for (int count = 1; count < 10; count++) {
			System.out.println("3 * " + count + "=" + (3 * count));
		}

		// 문1 : 키보드로 숫자를 받아 구구단 출력
		// 예) 몇 단? 3
		// 3*1=3 3*2=6...

		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단? ");
		int dan = sc.nextInt();
		for (int g = 1; g <= 9; g++) {
			System.out.println(dan + "*" + g + "=" + (dan * g));
		}

		// 문2: 1~100 사이의 정수 중 3의 배수이면서 5의 배수의 갯수과 그 합을 출력
		int gatsu = 0, hap = 0;

		for (int k = 1; k <= 100; k++) {
			if (k % 3 == 0 && k % 5 == 0) {
				gatsu = gatsu + 1; //gatsu +=1;과 형태가 같음
				hap = hap + k; // hap += k;과 형태가 같음
			}
		}
		System.out.println("개수 : " + gatsu + " 합 : " + hap);

		// 문3 : 2~9단까지 출력(다중 for)
		// 2*1=1 2*2=4... 
		// ...
		// 9*1=9 9*2=18...

		for (int x = 2; x <= 9; x++) {
			for (int y = 1; y <= 9; y++) {
				System.out.print(x + "*" + y + "=" + x * y + " ");
			}
			System.out.println();
		}
		// 한줄 완성 한 후 내려간뒤 다시 죽가는것.

	}
}
