package com.ssafy.lambda;

import java.util.function.Consumer;


/*
 * [자바에서 제공하는 함수형 인터페이스]
 * : 빈번히 사용되는 함수형 인터페이스들의 형태들을 미리 정의하여 제공
 * - java.util.function 패키지를 통해 제공
 * 
 * 빈번히 사용되는 형태 ?
 * 1. 파라미터가 없는 형태
 * 2. 파라미터가 하나, 두개 정도 있는 형태
 * 3. 반환 값이 없는 형태
 * 
 * - Consumer<T>
 * - Supplier<T>
 * - Function<T, R>
 * - Predicate<T>
 * -- 구현부만 달라짐
 * 1. Consumer<T> : 객체 T를 매개 변수로 받아서 사용, 반환값은 없는 형태의 함수형 인터페이스
 * 		소비자(파라미터O, 리턴X)
 * 		void accept(T t)를 추상메서드로 가짐
 * 2. 
 * 
 */
public class Lambda3_1_Consumer {
	

	public static void printStudent(Student student, Consumer<Student> printer) {
		printer.accept(student);
	}
		
	public static void main(String[] args) {
		//Consumer => 파라미터 소비, 리턴은 없음
		Student student = new Student("홍길동", 80);
		
		Consumer<String> consumer = (str) -> System.out.println(str);
		//T에 지정한 값이 매개 변수로 들어옴
		//accept메서드를 호출->람다식으로 구현한 내용이 실행됨
		consumer.accept("홍길동");
		
		printStudent(student,s->System.out.println(s.name));
		printStudent(student, s-> s.score*=1.5);
		printStudent(student, s->System.out.println(s.name + " : "+s.score));

	}
	

}

class Student{ //사용하기 위해 선언된 Student 객체
	public String name;
	public double score;
	
	Student(String name, double score){
		this.name = name;
		this.score = score;
	}
}
