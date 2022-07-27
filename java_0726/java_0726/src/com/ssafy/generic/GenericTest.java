package com.ssafy.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static class Test2{
		public Test2() { }
	}
	
	public static void main(String[] args) {
		
		//테스트용 아무 객체
		Test2 t2 = new Test2();
		
		//1. Generic을 적용하지 않은 경우
		List list = new ArrayList();
		list.add("HELLO");
		list.add(t2);
		list.add(3);//현재 list는 매개변수로 모든 객체, 타입들을 받아야함
					//--->Object 타입
		
		//list가 object 타입이여서 String으로는 받을 수 없어
		//강제 타입 변환이 필수적으로 이루어져야함
		//String->Object, t2->Object, int->Object
		//String str = list.get(0);
		String str = (String)list.get(0);
		System.out.println(str);
		
		List<String> list2 = new ArrayList<>();
		list2.add("HELLO");
		list2.add("world");
		
		//강제 타입 변환이 없어짐
		//why?? 담을때 String만 담았으니, return도 String으로 함
		String str2= list2.get(1);
		System.out.println(str2);
		
		//2. 제너릭 타입(class<T> interface<T>)
	    //객체에 정의되어 있던 T—>String으로 대체되면서 국한,  ClassType으로 국한
		Course<String> course = new Course<String>();
		course.set("SSAFY");//String이 잘 들어감
		//course.set(t2);
		//course.set(1);
		
		String str3 = course.get();
		System.out.println(str3);
		
		//3. 제너릭 메서드 호출
		//3-1. 리턴타입 변수 = <구체적 타입> 메서드명(매개값); //명시적으로 구체적 타입 지정 가능
		Course<String> course2 = Course.<String>courseX("SSAFY");
		String str4 = course2.get();
		
		//3-2. 리턴타입 변수 = 메서드명(매개값); //매개 값을 보고 구체적 타입을 추정
		Course<String> course3 = Course.courseX("GwangJu");
		String str5 = course3.get();
		//course3.set(2); //String아님
		
		System.out.println(str4);//SSAFY
		System.out.println(str5);//GwangJu
		
		/*
		 * 와일드 카드 언제 사용 ? 제네릭 클래스의 객체를 메서드의 매개변수로 받을 때 사용
		 * 시점 분리 : T는 객체 생성 시 타입 고정
		 * 와일드 카드는실행 중 타입을 정하는 역할
		 * */
		
	}

}
