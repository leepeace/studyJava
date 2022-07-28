package com.ssafy.lambda;

/*
 * 다양한 형태의 람다식
 * 1. 기본 람다식
 * (type 변수명[,..])-> {실행문;}
 */

public class Lambda2 {
	   public static void main(String args[]){
	      Lambda2 tester = new Lambda2();
			
	      //with type declaration
	      //파라미터가 하나인 경우 () 생략 가능
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //with out type declaration
	      // 파라미터 선언부의 파라미터 타입은 런타임시 대입되는 값에 따라서 자동 인식되므로 생략 가능
	      // 파라미터 하나일 경우 소괄호 생략 가능
	      MathOperation subtraction = (a, b) -> a - b;
	      
			
	      //with return statement along with curly braces
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      //실행 문장이 한문장일 경우 중괄호 생략 가능
	      //리턴 문장 하나로만 구성되는 경우 중괄호와 함께 return 키워드도 생략 가능
	      MathOperation division = (int a, int b) -> a / b;
			
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
	      
			
	      //without parenthesis
	      GreetingService greetService1 = message -> System.out.println("Hello " + message);
			
	      //with parenthesis
	      GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
			
	      greetService1.sayMessage("Mahesh");
	      greetService2.sayMessage("Suresh");
	   }

	   //람다식의 리턴타입은 "함수형 인터페이스"
	   //->반드시 하나의 abstract 메서드(추상 메서드)만 존재해야 함
	   //따라서 어노테이션을 붙이게 됨
	   @FunctionalInterface
	   interface MathOperation {
	      int operation(int a, int b);
	      //int operation2(int a);
	   }
	
	   @FunctionalInterface
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	   
}

