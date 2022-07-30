package com.example.polymorphism;

//자식 클래스
public class CaptionTv extends Tv {

	String text;
	
	void caption() {
		System.out.println("CaptionTv의 caption() 메서드 호출");
	}
	
}
