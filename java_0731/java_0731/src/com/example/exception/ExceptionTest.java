package com.example.exception;

/*
 * 1. getMessage()와 printStackTrace()에 대해 알아보자
 * 2. try-catch-finally에 대해 알아보자
 * */
public class ExceptionTest {
	public static void main(String[] args) {
		
		//1. getMessage()와 printStackTrace()에 대해 알아보자
		try {
			//수동으로 에러 이벤트를 발생시킴
			throw new Exception("error message");
		} catch (Exception e) {
			//에러 이벤트와 함께 들어오는 메시지 출력
			//Returns the detail message string of this throwable.
			System.out.println("getMessage() : " + e.getMessage());
			
			//에러의 발생근원지를 찾아서 단계별로 에러를 출력
			//Prints this throwable and its backtrace to thestandard error stream.
			System.out.print("printStackTrace() : ");
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("-------1. try-catch-finally--------");
		
		//System.out.println(printError());
	
		System.out.println("-------2. try-catch-finally--------");
		System.out.println(printReturnError());
	}
	
	public static String printError() {
		//2. try-catch-finally에 대해 알아보자
		try {
			throw new Exception();
		} catch (Exception e) {
			throw e;//finally안의 return문으로 인해 예외 무시됨
		} finally {
			System.out.println("finally문 출력");
			return "finally";
		}
	}
	
	//2. try-catch-finally에 대해 알아보자
	public static String printReturnError() {
		//2-1.finally return문 주석한 경우
		//try 블록 안에 return 문은 임시 변수에 결과 정보를 담아 두었다가
		//finally 블록을 실행한 뒤 임시 변수 정보를 반환함
		String name = "";
		try {
			name="try";
			//throw new Exception("error");
			return name;
		} catch (Exception e) {
			name="catch";
			return name;
		} finally {
			name="finally";
			//return name;//"finally" 반환
		}
	}
	
}
