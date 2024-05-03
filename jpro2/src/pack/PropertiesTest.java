package pack;

import java.io.FileInputStream;
import java.util.Properties;

// properties 파일 읽기
public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\ex.properties"));
			System.out.println(prop.getProperty("mes1"));
			System.out.println(prop.getProperty("mes2"));
		} catch (Exception e) {
			System.out.println("err: "+ e);
		}

	}

}
