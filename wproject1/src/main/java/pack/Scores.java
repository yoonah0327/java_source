package pack;

//한 명의 성적이 번호 이름 국어 영어로구성. 이름 하나의 객체로 만들기 위한 DTO(VO) 클래스
public class Scores{
	
	private int bunho;
	private String name;
	private int kor;
	private int eng;

	
	public Scores(int bunho, String name, int kor, int eng) {
		this.bunho= bunho;
		this.name= name;
		this.kor= kor;
		this.eng= eng;	
	}
	public int getBunho() {
		return bunho;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	
}
