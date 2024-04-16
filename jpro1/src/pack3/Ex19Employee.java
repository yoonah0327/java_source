package pack3;

abstract public class Ex19Employee {
	private String irum;
	private int nai;

	abstract public double pay();
	abstract public void print();


	public Ex19Employee(String irum, int nai) {
		this.irum = irum; //this.irum은 해당 클래스 전역변수irum.irum은 지역변수irum. 치환 assign
		this.nai = nai;
	}

	public void display() {
		System.out.print(irum + "," + nai + "," ); 
	}

}
