package com.ssafy.example.io;

import java.util.Scanner;

public class IoTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] input = new char[5];
		
		//char형으로 입력을 받고 싶은 경우
		//next()를 통해 입력받은 문자열에서 0번째에 있는 문자를 char타입을 변환한다.
		for(int i = 0; i < input.length; i++) {
			input[i] = sc.next().charAt(0);
		}
		
		sc.close();
	}

}
