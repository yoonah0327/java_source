package pack3;

public class Ex19Manager extends Ex19Regular{
private double incentive;

public Ex19Manager(String irum, int nai, int salary) {
	super(irum, nai, salary);
}
	
	@Override
	public void print() {
		display();
		if(pay() >=2500000) incentive= pay()*0.6;
		else if(pay() >=2000000) incentive= pay()*0.5;
		else if(pay() <2000000) incentive= pay()*0.4;
		System.out.println(super.pay() + incentive);
	}
	
	
}
