package pack3;

public class Ex19Temporary extends Ex19Employee {
	private int ilsu;
	private int ildang;

	public Ex19Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum, nai);
		this.ilsu = ilsu;
		this.ildang = ildang;
	}

	@Override
	public double pay() {
		return ilsu * ildang;
	}

	@Override
	public void print() {
		display(); // 이름 나이 값 뒤에 pay 값을 바로 붙이려면 display메소드에서 println이 아니라 print하기. ln은 출력 후 라인스킵.
		System.out.println(pay()); // 
	}

}
