package com.ssafy.live4.exception.custom;

//사용자 정의 예외
public class NoSpaceException extends RuntimeException {

	public NoSpaceException(String name) {
		super(name + " 을 더이상 넣을 공간이 없어요ㅠ");
	}
	
}
