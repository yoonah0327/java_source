package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 제3자가 제공하는 라이브러리(jsoup.jar)를 사용해 웹 스크래밍 
// HTML 문서 데이터 구문 분석, 추출 및 조작용 오픈 소스
public class Net2 {

	public static void main(String[] args) {
		// 위키백과 사이트에서 검색 결과 읽기
		//https://ko.wikipedia.org/wiki/%EB%B0%B1%EC%84%A4_%EA%B3%B5%EC%A3%BC
		try {
			//System.out.println(URLEncoder.encode("백설공주", "UTF-8"));
			
			String url = "https://ko.wikipedia.org/wiki/" + URLEncoder.encode("백설공주", "UTF-8");
			
			// 웹페이지 문서 : Document
			Document doc = Jsoup.connect(url).get(); // url 자료 연결
			String text = doc.text(); // 웹문서의 텍스트를 모두 읽는것
			System.out.println(text);
			
			printKoreanText(text); // 한글만 추출
		} catch (Exception e) {
			System.out.println("err: "+e.getMessage());
		}
	}
	private static void printKoreanText(String text) {
		// 정규표현식 사용하여 한글과 공백만 얻기 : Pattern 
		Pattern pattern = Pattern.compile("[가-힣\\s]+");  // \\s 공백, +는 한글자씩 읽는게 아니도록 
		Matcher matcher = pattern.matcher(text);  // 이 두 문장의 의미는??? 
		
		while(matcher.find()) {
			String line = matcher.group().trim(); // 라인단위로 읽기. trim: 공백자르기
			if(!line.isEmpty()) { //빈줄제외
				System.out.println(line);
			}
		}
			
	}
}
