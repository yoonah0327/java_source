package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 멀티 스레드로 멀티 태스킹: 복수개의 문서 읽기. 순서는 랜덤(빵접시 케이스연습)
public class Net3Thread implements Runnable {

	private String url;
	private String title;

	public Net3Thread(String url, String title) {
		this.url = url;
		this.title = title;
	}

	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(url).get(); // 네트워크를 통해 다른 컴에 접속후 자료읽기
			String text = doc.text();

			System.out.println("------------");
			System.out.println("문서제목: " + title);

			printKoreanText(text);
		} catch (Exception e) {
			System.out.println("read err:" + e);
		}

	}

	private static void printKoreanText(String text) {
		// 정규표현식 사용하여 한글과 공백만 얻기 : Pattern
		Pattern pattern = Pattern.compile("[가-힣\\s]+"); // 
		Matcher matcher = pattern.matcher(text); //

		while (matcher.find()) {
			String line = matcher.group().trim(); // 라인단위로 읽기. trim: 공백자르기
			if (!line.isEmpty() && line.length() > 1) { // 빈줄, 한 글자 제외
				System.out.println(line);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String[] titles = { "백설공주", "인어공주" };

		String[] urls = { "https://ko.wikipedia.org/wiki/" + URLEncoder.encode(titles[0], "UTF-8"),
				"https://ko.wikipedia.org/wiki/" + URLEncoder.encode(titles[1], "UTF-8")

		};

		for (int i = 0; i < urls.length; i++) {
			Thread thread = new Thread(new Net3Thread(urls[i], titles[i]));
			thread.start();
		}

		System.out.println("~~~~프로그램 종료~~~~"); // 스레드는 랜덤이다. 그래서 얘가 꼭 마지막에 출력되지는 않는다.
		// 꼭 마지막에 출력하고 싶다면 join을 실시하자
	}

}
