package pack;

public class Test8for {

	public static void main(String[] args) {
		// 반복문 : continue, break
		System.out.println("뭔가를 하다가...");

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			if(i==3) continue; //3일때는 아래문장을 무시. 자기와 대응되는 조건문으로 다시 올라감. BACK
			if(i==5) break; // 자기가 포함된 반복문을 나와버림. OUT ESCAPE
			//if(i==5) Sysyem.exit(0); // 응용프로그램종로 
		System.out.println("금요일");
			
		}
		System.out.println(); // 무한반복출력에 브레이크걸기. 무한반복은 보통 while문에 사용.
		int kk = 0;
		for(;; ) {
			kk++;
			System.out.println("무한 반복 출력");
			if(kk == 10) break;
		}
		
		System.out.println(); //for문 앞에 라벨 달음
		kbs:for(int i=1; i <= 3; i++ ) {
			mbc:for(int j=1; j <=5; j++) {
				System.out.print(i + " "+ j + "  " );
				if(j==3) continue kbs;  //해당 label로 분기. 원래대로라면 mbc나와서~~~~ 만나야했음. 
				if(j==5) break kbs;
			}
			System.out.println("~~~~~~~~~~~~");
		}
	}
}
