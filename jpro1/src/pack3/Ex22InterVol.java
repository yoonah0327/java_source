package pack3;

//public interface Ex22InterVol {
public interface Ex22InterVol extends Ex22VolEtc { 
	
	//인터페이스간 상속.intervol는 추상메소드4개, voletc는 여전히 추상메소드2개.
	String vol = "볼륨";
	
	void volup(int v);
	void voldown(int v);

}
