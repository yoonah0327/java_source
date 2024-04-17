package pack4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28ListTest {
	
	public static void main(String[] args) {
		// list류의 Arraylist로 연습: 중복가능, 순서 유
		ArrayList<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park");
		list.remove(0); //list는 가능, set은 불가
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
