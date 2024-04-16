package pack;

import java.util.Scanner;

public class Test9while {

	public static void main(String[] args) {
		// 반복문 while
		// while(조건) {실행문..}
		int w = 1;
		while (w <= 5) {
			System.out.print("w = " + w + " "); // 못 빠져나오고 무한반복. console에서 정지시켜줘야함.
			w++; // for문은 조건문안에 증감치있고, while문은 실행문안에 증감치있음.
		}
		System.out.println("\nwhile 수행 후 w:" + w);

		System.out.println();
		int count = 0;
		while (count < 5) {
			count++;
			System.out.println("count : " + count);
			if (count == 3) {
				System.out.println("쉬어가기");
			}
			if (count == 5) {
				System.out.println("count가 5라서 종료");
			}
		}
		System.out.println();
		w = 0;
		while (true) { // 무한 루프. for문은 정해진 반복. while은 범위가 정해지지 않은, 무한 반복.
			w++;
			if (w == 5)
				break; // 5는 while문 탈출. w는 5출력
			if (w == 3)
				continue; // 밑으로 안내려가고 while 시작으로
		}
		System.out.println("w는 " + w);

		System.out.println();
		// factorial. n! = n*(n-1)*...*1
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("정수 입력:");
//			int number = scanner.nextInt(); // API를 가져다 적용

		int number = 5;
		// factorial 계산을 위한 초기값 설정.
		int factorial = 1;
		int i = 1; // 반복을 위한 counter 변수
		while (i <= number) {
			// System.out.println(i);
			factorial *= i;
			i++;

		}
		System.out.printf("number는 %d factorial은 %d이다", number, factorial); // 3-4단원의 입출력 부분.

		System.out.println("\n 다중 while -----");
		int a = 1;
		while (a <= 3) {
			System.out.println("a : " + a);
			int b = 1;
			while (b <= 4) {
				System.out.print("b : " + b);
				b++;
			}
			a++;
			System.out.println();
		}
		System.out.println();
		/*
		 * //키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지 모든 수에 // 나누기를 시도하고 나누어 떨어지는 경우(약수) 그 수를
		 * 출력한다. // 0이나 음수를 입력하면 프로그램 종료. Scanner scanner = new Scanner(System.in);
		 * while(true) { System.out.println("정수 입력(0이나 음수면 종료):"); int num =
		 * scanner.nextInt(); // API를 가져다 적용 if(num <= 0) {
		 * System.out.println("프로그램 종료"); break; } System.out.println(num + "의 약수는");
		 * int divisor = 1; //약수를 찾기 위해 1부터 시작 while(divisor <= num) { if(num % divisor
		 * == 0) { System.out.println(divisor); // 약수 출력 } divisor++; // 다음수로 이동
		 * 
		 * } }
		 */
		System.out.println();
		// do {반복 수행문}while(조건);
		int k = 10;
		do { // 최소 1회는 수행
			System.out.println("k : " + k);
			k++;
		} while (k <= 5);

		System.out.println("exam ----------");
		// 문1) 1~100 사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고, 합과 갯수도 출력
		int x = 1, gatsu = 0, hap = 0;
		while (x <= 100) {
			if (x % 3 == 0 && x % 2 != 0) {
				System.out.println(x);
				hap = hap + x; // hap += x;
				gatsu = gatsu + 1; // gastu += 1;
			}
			x++;
		}
		System.out.println("합: " + hap + " " + "갯수: " + gatsu);

		// 문2) -1, 3, -5, 7, -9, 11 ... 99 까지의 합 출력
		System.out.println();
		int y = 1;
		int happ = 0;
		while (y < 100) {

			if (y % 4 == 1) {
				happ = happ - y;
			} else {
				happ = happ + y;
			}
			y = y + 2;

		}
		System.out.println(happ);

		// 문2 선생님 해설
/*
		int c = 1, cnt = 1, hab = 0;
		while (c < 100) {
			if (cnt % 2 == 0) {
				hab += c;
			} else {
				hab += c * -1;
			}
			System.out.println(c);
			c += 2;
			cnt += 1;
		}
*/
		// 문2 for로 출력
	/*
		int hab2= 0, cnt2 =1;
		for(int c2=1; c2 < 100; c +=2) {
			if(cnt2 % 2 ==0) {
				hab2 += c2;
			}else {
				hab2 += (-1) * c2;
			}
			cnt2++;
		}
		System.out.println("for 합은 " + hab2 + "입니다");
		
     */
		// 문3) 1~100 사이의 정수 중에서 소수와 그 갯수를 출력
		// 소수 : 1보다 크며 1과 그 수 자체이외의 다른 수로는 나누어 떨어지지 않는 수

		int aa = 2;
		int count2 = 0;
		System.out.println("1부터 100까지의 소수");
		while(aa <= 100) {
			boolean imsi = false; // 값이 소수인것 
			
			int bb = 2;
			while(bb <= aa -1) {
				if(aa % bb ==0) {
					imsi = true; // 값이 소수가 아니라는것.
				}
				bb++;
			}
			if(imsi == false) {
				System.out.println(aa + "");
				count2++;
			}
			aa++;
		}
		System.out.println("\n건수 : " + count2);
		
		System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지는지");
		// 소수를 찾는 잉로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의제곱근을
		int num = 2; //1은 소수가 아니므로 2부터 출발
		int count3 = 0; // 건수
		System.out.println("1부터 100까지의 소수 : ");
		while(num <= 100) {
			boolean isPrime = true; // 현재 숫자가 소수인지 판별
			int divisor = 2; // 나는 수는 2부터 시작
			while(divisor <= Math.sqrt(num)) {
				if(num % divisor ==0) {
				isPrime = false;
				break;  // 나누어 떨어지지않으면 더 이상의 검사는 필요 없음. 
			}
			divisor++;
		}
		if(isPrime) {// if(isPrime) == true {과 같은 식임.
			count3++; // 소수의 갯수 증가 
			System.out.print(num + " ");
		}
		num++;
		}
		System.out.println("\n건수 : " + count2);
	}
}
