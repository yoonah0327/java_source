package pack4;

import java.util.HashSet;
import java.util.Iterator;

// Collection: 다수의 객체를 여러개 담을수있는 집합형 자료구조  
public class Ex27SetTest {

	public static void main(String[] args) {
		// Set류의 HashSet으로 연습: 중복불가, 순서x
		
//		Ex27SetTest test = new Ex27SetTest();
//		HashSet<Ex27SetTest> list = new HashSet<Ex27SetTest>();
//		list.add(1);
//		list.add(test);
		
		HashSet<String> list = new HashSet<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park");
		//list.clear();
		System.out.println("크기:" + list.size());
		

		for (Object obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		// Iterator 반복자
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
		
	}

}
