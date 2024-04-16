package pack3;

public class Ex19Salesman extends Ex19Regular {
	private int sales;
	private double commission;

	public Ex19Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum, nai, salary); // 부모 클래스의 생성자를 호출하는 super메소드.
		this.sales = sales;
		this.commission = commission;
	}

	@Override
	public double pay() {
		return (super.pay() + sales * commission);
	}

	@Override
	public void print() {
		display();
		System.out.println(pay());
	}
}
