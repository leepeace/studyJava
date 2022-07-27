package com.ssafy.live4.exception.custom;

//사용자 정의 예외
public class FruitNotFoundException extends Exception {

	public FruitNotFoundException(String name) {
		super(name + "앗! 그런 과일은 없어요!");
	}

}
