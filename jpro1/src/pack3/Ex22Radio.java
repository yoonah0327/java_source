package pack3;

//public class Ex22Radio implements Ex22InterVol, Ex22VolEtc { //,찍고 다중상속 가.
public class Ex22Radio implements Ex22InterVol { //이미 다중상속햇기에 추상메소드4개인건 동일.
	private int v = 0;

	@Override
	public void volup(int v) {
		this.v +=v;

	}

	@Override
	public void voldown(int v) {
		this.v -=v;

	}

	@Override
	public void volOff() {
		 v= 0;

	}

	@Override
	public void volOn() {
		v= 1;

	}
public void showVol() {
	System.out.println("현재 볼륨은 " + v);
}
}
