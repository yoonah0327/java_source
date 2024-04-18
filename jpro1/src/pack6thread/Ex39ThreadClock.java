package pack6thread;
// 스레드로 시계창띄우기..
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ex39ThreadClock extends Frame implements ActionListener, Runnable {
	Label lblMessage;
	boolean bExit = false;
	Thread thread;

	public Ex39ThreadClock() {
		lblMessage = new Label("show time", Label.CENTER);// 대문자 final? 기운글자 static?
		super.add("Center", lblMessage);

		Button btnClick = new Button("click");
		super.add("South", btnClick);
		btnClick.addActionListener(this);// implements ActionListener했으니

		setTitle("스레드 시계");
		setBounds(200, 200, 300, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				bExit = true; //false 갖고 있다가 윈도우클로징일때 true.
				//run()의 무한루핑을 탈출하기 위해 
				System.exit(0);
			}
		});
		thread = new Thread(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼클릭하면 수행될 메소드
		// System.out.println("와우");
		//showData();
		//만약 사용자 정의 스레드가 이미 있다면 start()를 호출하지않는다.
		if(thread.isAlive()) return; //조건이 되어 return이 되면 하단의 스레드 실행 ㄴ.
		thread.start();
		
	}

	@Override
	public void run() {
		while(true) {
			//if(bExit == true) break;
			if(bExit) break;
			showData();
			try {
				Thread.sleep(1000);//1초동안 비활성화
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	private void showData() {
		LocalDate date = LocalDate.now(); // 싱글톤패턴
		int y = date.getYear();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();

		LocalTime time = LocalTime.now();
		int h = time.getHour();
		int mi = time.getMinute();
		int s = time.getSecond();

		String ss = y + "-" + m + "-" + d+ " "+h+ ":"+ mi+ ":"+ s;
		
		lblMessage.setText(ss);
		lblMessage.setFont(new Font("Times new Roman", Font.BOLD, 20));

	}
	
	public static void main(String[] args) {
		// 스레드를 이용한 날짜 시간 표시
		new Ex39ThreadClock();

	}

}
