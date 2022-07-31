package com.example.access;

/*
 * 1. this()를 통해 같은 클래스의 다른 생성자를 호출할때 사용할 수 있다.
 * 2. this : 인스턴스 변수와 매개변수로 선언된 변수의 이름이 같을 때 구분하기 위해 사용된다.
 * */
public class ThisKeyWordTest {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s);
		
		s = new Student("김동깨");
		System.out.println(s);
		
	}
}

class Student{
	String name;//인스턴스 변수
	int age;//인스턴스 변수
	int studentNum;//인스턴스 변수
	
	Student() {
		this("홍길동");
	}
	
	Student(String name) {
		this(name, 20, 20190123);
	}
	
	Student(String name, int age, int studentNum) {
		this.name = name;
		this.age = age;
		this.studentNum = studentNum;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentNum=" + studentNum + "]";
	}
	
	
}