package pack3;

public class Ex18FindUtil {
	public static void find(Ex18Animal ani) {
		ani.animalPrint();
		
		// instance of : 객체타입비교연산자. 참 거짓 반환.
		if(ani instanceof Ex18Cow) {
			Ex18Animal a = ani;
			System.out.println(a.name());
			System.out.println(a.eat());
		}else if(ani instanceof Ex18Lion) {
			System.out.println(ani.name());
		}
	}
}
