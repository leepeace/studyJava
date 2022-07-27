package com.ssafy.lambda;


/**
 * 다양한 형태의 람다식이 있음
 * 1. 기본 람다식
 * (type 변수명[, ...])->{실행문;}
 * 
 *
 */
public class Lambda2 {

	public static void main(String[] args) {
		Lambda2 tester = new Lambda2();
		
		MathOperation addition = (int a, int b) -> a+b;
		MathOperation subtraction = (a, b) -> a-b;
		MathOperation multiplication = (int a, int b)->{ return a*b; };//return문 생략 가능
		
		System.out.println(tester.operate(5, 7, addition));
		System.out.println(tester.operate(7, 1, subtraction));
		System.out.println(tester.operate(4, 2, multiplication));
	}

	interface MathOperation{
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
}
