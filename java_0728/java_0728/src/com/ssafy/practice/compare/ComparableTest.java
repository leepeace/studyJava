package com.ssafy.practice.compare;

/*
 * Comparable : 자기 자신과 매개변수 객체를 비교함
 * 
 * */
public class ComparableTest {

	public static void main(String[] args) {
		Student s1 = new Student(17, 2102);
		Student s2 = new Student(15, 1000);
		
		if(s1.compareTo(s2) >= 1) {//s1의 age가 더 큰 경우
			System.out.println("s1의 age가 더 큼");
		}else if(s1.compareTo(s2) == 0) {//s1과 s2의 age가 같은 경우
			System.out.println("s1과 s2의 age가 같은 경우");
		}else {//s1의 age < s2의 age
			System.out.println("s1의 age < s2의 age");
		}
		
	}

}
