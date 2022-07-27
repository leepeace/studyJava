package com.ssafy.live4.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckedExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
    	try {
            Class.forName("abc.Def"); // ClassNotFoundException
            new FileInputStream("Hello.java"); // FileNotFoundException
            DriverManager.getConnection("Hello"); // SQLException    		
    	}catch(ClassNotFoundException | FileNotFoundException e) {
    		System.out.printf("자원을 찾을 수 없습니다. : %s %n", e.getMessage());
    	}catch (SQLException e) {
			System.out.printf("DB 접속 실패. : %s %n", e.getMessage());
		}catch (Exception e) {
			System.out.println("기타 에러  " + e.getMessage());
		}

        // END:
        System.out.println("프로그램 정상 종료");
    }



}
