package com.ssafy.practice.compare;

/*
 * Comparable : 자기 자신과 매개변수 객체를 비교함
 * 
 * */
public class Student implements Comparable<Student>{

	int age;
	int classNumber;
	
	public Student() {
		
	}

	public Student(int age, int classNumber) {
		super();
		this.age = age;
		this.classNumber = classNumber;
	}
	
	//자기 자신과 파라미터로 받은 Student객체를 비교함
	//자기 자신을 기준으로 삼아 대소관계를 파악함
	//자기 자신을 기준으로 상대방과의 차이 값을 비교하여 반환할 수 있다.
	@Override
	public int compareTo(Student s) {
		
		if(this.age > s.age) {//자기자신의 age가 s의 age보다 크다면 양수
			return 1;
		}else if(this.age == s.age) {//자기자신의 age가 s의 age와 같다면 0
			return 0;
		}else {//자기자신의 age가 s의 age보다 작다면 음수
			//this.age < s.age의 경우
			return -1;
		}
	}
	
	
	
}
