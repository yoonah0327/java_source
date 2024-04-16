package pack3;

public interface Ex21Resume { // 이력서 표준 양식
	String SIZE = "A4";// public final static

	void setIrum(String irum);
	void setPhone(String phone);
	void printData();

	default void disply(boolean b) { // java 1.8이후에 가능
		if (b) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
	}
// 일반적으로는 파이널과 추상메소드로만 이루어진게 맞음.
	static void play() { // 특별하게 default, static도 있음. 
		System.out.println("play 메소드");
	}

}
