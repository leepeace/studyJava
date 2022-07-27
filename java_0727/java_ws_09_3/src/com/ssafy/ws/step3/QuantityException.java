package com.ssafy.ws.step3;

/**
 * 수량이 부족한 상황을 나타내는 예외클래스
 */
public class QuantityException extends RuntimeException {

	public QuantityException() {
		super("수량이 부족합니다.");
	}
	
}
