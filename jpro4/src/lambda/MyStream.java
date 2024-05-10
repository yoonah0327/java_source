package lambda;
 // 자바8 스트림
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Stream 인터페이스: 컬렉션, 배열 등의 저장 요소를 하나씩 참조하여 인터페이스(람다식)를 적용. 반복처리 가능.
// 반복자 역할. 정렬, 집계, 빅데이터 처리도 가능.
// 1회용. 내부 반복으로 작업 처리. 원본 데이터를 변경하지 않음. 
public class MyStream {
	public MyStream() {
		test1(); // stream 생성
		test2(); // 컬랙션에 Stream 적용
		test3(); // VO 클래스 사용

	}

	private void test1() {
		// 1) Collection의 스트림 생성
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> listStream = list.stream();
		// 2) 배열의 스트림 생성
		Stream<String> stream1 = Stream.of("a", "b", "c");
		Stream<String> stream2 = Stream.of(new String[] { "a", "b", "c" });
		Stream<String> stream3 = Arrays.stream(new String[] { "a", "b", "c" });
		Stream<String> stream4 = Arrays.stream(new String[] { "a", "b", "c" }, 0, 3); // 0이상 3미만 배열요소를 포함.

		// 3) 원시(기본형 데이터) stream 생성
		IntStream istream = IntStream.range(5, 10); // 5이상 10미만의 숫자를 갖는 스트림 생성
		// DoubleStream
		istream.forEach(para -> System.out.println(para + " "));

	}

	private void test2() {
		List<String> list = Arrays.asList("레밍스", "팩맨", "마리오");
		// list.add("소닉"); // 새로운 요소 추가불가. 기존 요소 삭제불가. 문법적오류는 없으나(신택스에러) 런타임에러.
		Iterator<String> iter = list.iterator(); // 외부 반복자 사용. 전통적
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("---");
		for(String str:list) { // 향상된 for문. 전통적.
			System.out.println(str);
			
		}
		System.out.println("----");
		Stream<String> stream = list.stream(); // Steam 객체 생성
		stream.forEach(str -> System.out.println(str)); // 그리고 람다. 내부 반복으로 작업처리
		//stream.forEach(str -> System.out.println(str)); // err: 1회용! 다시 만들어주어야한다
		 
		list.stream().forEach(str -> System.out.println(str)); // 새로만들어주면 잘찍힌다. stream 객체 생성후출력
		list.stream().forEach(System.out::println); // ::(람다표현식 중 하나)으로 출력하는것. 윗줄과같은데다른표현!!
		
		System.out.println();
		//< 스트림을 사용하여 체이닝 작업> : 모든 필요한 작업을 단일 스트림 파이프라인(일련의 처리단계)에서 처리
		// Functional interface 함수지향적표현방법 
		// lazy evaluation: 직역하면 "게으른 연산". 불필요한 연산을 피하기 위해 연산을 지연시키는 것.
		// stream peek
		// 어떤 스트림의 요소들 합을 구하는 과정에서 요소값을 먼저 출력하고 싶은경우
		int sum = IntStream.of(1,3,5,7).peek(System.out::println).sum(); // count, max..
		System.out.println("합은 "+ sum);
		
		list.stream().peek(System.out::println).forEach(System.out::println);
		
		System.out.println("\n병렬처리 streamPar");
		Stream<String> streamPar = list.parallelStream(); // 병렬 스트림 객체 생성
		streamPar.forEach(str -> System.out.println(str)); // 랜덤출력
		
		System.out.println("\n정렬 streamSort");
		Stream<String> streamSort = list.stream().sorted(); // 기본은 ascending(오름차순)..?레마팩으로출력됨..?
		Stream<String> streamSort2 = list.stream().sorted(Comparator.reverseOrder()); // 내림차순으로 바꿔보기. 팩마레출력. 왜?
		streamSort.forEach(System.out::println);
		streamSort2.forEach(System.out::println);
		
		Stream<String> streamSort3 = list.stream().distinct().sorted(); // 중복제거 
		
	}

	private void test3() {
		System.out.println("\n\nVO 클래스로 컬랙션 작성");
		List<Student> slist = Arrays.asList(
				new Student("레밍스", "남", 22),
				new Student("팩맨", "남", 25),
				new Student("마리오", "남", 28),
				new Student("피치", "여", 20),
				new Student("마라라", "여", 22)
				);
		Stream<Student> stream = slist.stream();
		stream.forEach(p -> {
			System.out.println(p.getName() + " "+p.getAge()+ " "+p.getGender());
			});
		System.out.println("컬랙션자료에 대한 중간 처리, 최종 처리가 가능함"); 
		// 각 개인의 나이를 출력하고, 최종 나이의 평균 출력
		// 방법1 optionaldouble
		double avg = slist.stream() // stream 객체생성
				.mapToInt(Student :: getAge) // student 객체를 age 값으로 매핑해 age로 새스트림 생성
				.average() // 내부적으로 age요소의 평균을 optionalDouble에 저장. 값이 없을 수도 있다는 가정.
				.getAsDouble(); //optionalDouble에 저장.
		System.out.println("나이 전체 평균은 "+avg);
		
		// 방법2
		double avg2 = slist.stream().collect(Collectors.averagingInt(Student :: getAge));
		System.out.println("나이 전체 평균은 "+ avg2);
		
		// 방법3
		OptionalDouble result = slist.stream()
				.mapToDouble(Student :: getAge)
				.average();
		result.ifPresent(res -> System.err.println("나이 전체 평균은 "+ res));
		
		// 필터 처리 
		// 남 나이평균 // filter에 마우스대보면 predicate뜬다. 스트림이 제공하는 filter메소드를 사용해보았다. 
		double avgM = slist.stream()
				.filter(m -> m.getGender().equals("남"))
				.mapToInt(Student :: getAge)
				.average()
				.getAsDouble(); // optionalDouble에 저장된 값읽기 
		System.out.println("남자 나이 평균: "+avgM);
		
		// "마"성을 가진 이름 필터
		slist.stream().filter(ir -> 
		ir.getName().startsWith("마"))
		.forEach(irum -> System.out.println(irum.getName()));
		
	}
	
// 내부클래스
	class Student{
		private String name;
		private String gender;
		private int age;
		
		public Student(String name, String gender, int age) {
			this.name = name;
			this.gender = gender;
			this.age = age;
			
		}

		public String getName() {
			return name;
		}


		public String getGender() {
			return gender;
		}

		
		public int getAge() {
			return age;
		}

		
		
	}
	public static void main(String[] args) {
		new MyStream();

	}

}
