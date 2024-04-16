package pack3;

/* <인터페이스> 추상클래스의 연장버젼임. 
 * 추상 메소드와 상수로 구성된 클래스. 클래스인데 특별한 클래스여서 인터페이스라는 이름을 붙여주었음.
 * 다중상속이 가능.
 * 인터페이스는 인스턴스(new) 불가.
 * 인터페이스는 자식 클래스에서 implement 키워드로 구현. 
 * 인터페이스간 상속 가능.
 */
public interface Ex20Volume {
	void volumeUp(int level); // public abstract void volumeUp(int level);와 같은뜻.
	void volumeDown(int level);
	
//	void print() { 
//		// 에러. 일반메소드는 사용불가.
//	}
	
	
}
