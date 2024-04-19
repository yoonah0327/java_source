package pack6thread;
//java.lang안에 있는 애들은 임포트생략임. Thread, syso 등.
public class Ex37Thread1 extends Thread{ //스레드를 상속받음 ////////////////////////////////
	public Ex37Thread1() { //기본생성자
		// TODO Auto-generated constructor stub
	}
	public Ex37Thread1(String name) { // 매개변수1개인 생성자
		super(name);
	}
	public void run() {
	for(int i=1; i <=50; i++) {
		//System.out.print(i+ " ");
		System.out.print(i+ ":"+super.getName()+" ");
	}
	}
	public static void main(String[] args) {
		// Thread 
		// 하나의 응용 프로그램은 운영체제에 의해 process(작업단위)를 확보.
		// 응용프로그램의 실행은 thread(실행단위)가 담당한다.
		// 기본적으로 main thread에 의해 응용프로그램 실행.
		// thread의 갯수만큼 실행단위를 늘릴수있다. 즉 multi thread에 의한 multi tasking가. 
		// 주로 네트워크 작업에서 많이 활용된다.
		//자바에서 실행 파일 직접 실행
		try {
			//Process 단위의 실행
			//Process p1 = Runtime.getRuntime().exec("calc.exe");
			
			
			//Thread를 사용하지 않은경우: 순차적으로 실행. thread1수행이 끝나야, thread2수행가.
//			Ex37Thread1 th1 = new Ex37Thread1();
//			th1.run();
//			Ex37Thread1 th2= new Ex37Thread1();
//			th2.run();
			
			//Thread를 사용한 특정 메소드(run)실행
			//사용자 정의 Thread를 사용한 경우: 랜덤하게 실행. 
			//Ex37Thread1 th1 = new Ex37Thread1();
			Ex37Thread1 th1 = new Ex37Thread1("one");
			th1.start();//start가 run을 실행함. 
			//Ex37Thread1 th2= new Ex37Thread1();
			Ex37Thread1 th2= new Ex37Thread1("two");
			th2.start(); 
			
			// MAX_PRIORITY = 10 // 최대 우선순위
			// MIN_PRIORITY = 1 //최소 우선순위
			th2.setPriority(MAX_PRIORITY); //스레드 스케쥴러에게 우선순위요청
					
			th1.join(); //th1 스레드가 종료될때까지 main스레드 종료를 대기
			
			th1.yield(); //다른 스레드의 수행요청이 들어오면 현스레드의 수행일시정지
			
			System.out.println("\n프로그램 종료");
		} catch (Exception e) {
			System.out.println("err: " +e);
		}

	}

}
