package com.ssafy.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 람다식 : 익명 함수를 생성하기 위한 식
 * ->자바 코드가 간결해지는 효과
 * */
public class LambdaTest {
	
	public static void main(String[] args) {
		List<String> names1 = new ArrayList<String>();
		
		names1.add("abcd");
		names1.add("ssafy");
		names1.add("bsfg");
		names1.add("zxcv");
		names1.add("gwangju");
		
		List<String> names2 = new ArrayList<String>();
		
		names2.add("abcd");
		names2.add("ssafy");
		names2.add("bsfg");
		names2.add("zxcv");
		names2.add("gwangju");
		
		LambdaTest tester = new LambdaTest();
		
		System.out.println(names1);
		tester.sortUsingJava7(names1);
		System.out.println();
		
		System.out.println(names2);
		tester.sortUsingJava8(names2);
		System.out.println();
	}
	
	//기존 익명함수
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
	}
	
	//람다식
	//람다식을 적용하면 간결해짐
	//객체가 필요한 자리에 코드 블록만 전달
	//람다식은 런타임시에 익명의 내부 클래스로 변경돼서 처리되므로 동작은 동일
	// (매개변수, ..)->{}  
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2)->s1.compareTo(s2));
	}
	
	
}
