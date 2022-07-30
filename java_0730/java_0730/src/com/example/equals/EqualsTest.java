package com.example.equals;

public class EqualsTest {

	public static void main(String[] args) {
		
		//new연산자를 통해 String클래스 타입의 인스턴스(객체)를 생성했다.
		//따라서, s3와 s4에는 주소값이 들어가게 된다.
		String s3 = new String("BYE");
		String s4 = new String("BYE");

		System.out.print("주소값으로 판단 : ");
		//메모리에 있는 주소로 판단
		if(s3 == s4){
			System.out.println("s3==s4");
		}else {
			System.out.println("s3 != s4");
		}
		
		System.out.print("equals메서드 : ");
		if(s3.equals(s4)) {
			System.out.println("s3 == s4");
		}else {
			System.out.println("s3 != s4");
		}
		
	}

}
