package com.ssafy.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/*
 * Function<T, R> : 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스
 * (파라미터O, 리턴 O)
 * R apply(T t)를 추상메서드로 가짐
 * */
public class Lambda3_3_Function {

	private Person person;

	public void addPerson(BiFunction<String, Integer, Person> function, String name, Integer age) {
		person = function.apply(name, age);
	}

	public void printPerson(Function<String, String> function, String name) {
		System.out.println(function.apply(name));
	}

	public void printAge(ToIntFunction<String> function, String name) {
		System.out.println(name + "의 나이: " + function.applyAsInt(name));
	}

	public static void main(String[] args) {

		Lambda3_3_Function ft = new Lambda3_3_Function();

		Function<String, Person> person = (name) -> {return new Person(name , 20); };
		System.out.println(person.apply("홍길동"));
		
		ft.addPerson((name, age) -> {
			return new Person(name, age);
		}, "홍길동", 10);
		
		ft.printPerson((name) -> {
			if (ft.person.name.equals(name)) {
				return ft.person.toString();
			} else {
				return "unknown user";
			}
		}, "홍길동");
		
		ft.printAge((name) -> {
			if (ft.person.name.equals(name)) {
				return ft.person.age;
			} else {
				return 0;
			}
		}, "홍길동");

	}

}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
