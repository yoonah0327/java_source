package debugtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import debug.Calculator;

public class CalculatorTest {
	//Calculator calculator = new Calculator();
	Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}

	@Test
	public void testPlus() {
		
		//assertTrue(calculator.plus(8, 4) == 12);
		
		
		int a = 8, b = 8;
		assertEquals(a, b); // 변수의값이 같은지 확인 
		
//		int[] arr = {0,1};
//		int arr2[] = new int[2];
//		assertArrayEquals(arr, arr2); // 두 배열 요소값 비교
		
		
	}
	@Ignore
	@Test
	public void testMulti() {
		fail("Not yet implemented");
	}
	@Test(timeout = 1000) // 1초 단위로 수행시간 검사
	public void testDevide() {
//		assertTrue(calculator.divide(8, 4) == 2);
//		assertTrue(calculator.divide(10, 4) == 2.5);
		
		for (int i = 0; i < 1000000; i++) {
			System.out.print(i + " ");
			
		}
	}


}
