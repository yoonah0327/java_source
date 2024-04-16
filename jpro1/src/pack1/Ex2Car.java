package pack1;

public class Ex2Car {
	private int speed; 
	public String irum;
	private double weight;

	public Ex2Car() {
		irum = "홍길동";
		speed = 10;

	}

	public void showData() {    
		System.out.println("이름은 " + irum + ", 속도는 " + speed);

	}

// setter. set+대문자시작단어로 약속.
	public void setSpeed(int s, int password) { // private 멤버값을 외부에서 접근하기 위한 메소드
		if (password == 123) {
			speed = s;   // this 써도되지만, 여기앞에 this적는건 낭비. 그래서 안씀. 
		} // 비번123을 맞추면, 스피드값을 줄게.
	}

	// 반환값이 없으면 void. 정수면 int. 등등 맞춰서.
// getter.
	public int getSpeed() {
		return speed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;  //
		// 멤버필드weight에 지역변수 weight 값을 치환. 둘이보기엔 같은데, 다른거니까. this: 현재클래스내의멤버를 일컬음. 여기선 반드시 써야함.
		// this 와 this()는 서로 다름. 주의. 
	}

}
