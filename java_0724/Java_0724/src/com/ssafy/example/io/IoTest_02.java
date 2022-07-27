package com.ssafy.example.io;

import java.util.Arrays;
import java.util.Scanner;

public class IoTest_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = new char[5];
		
		int sum = 0;
	
		//char->int형으로 변환하고 싶은 경우
		//charAt(0)-'0'을 하면 원하는 숫자를 얻을 수 있다.(아스키코드로 변환)
		for(int i = 0; i < input.length; i++) {
			sum += sc.next().charAt(0) - '0';
		}
		
		System.out.println(sum);
	}

}
