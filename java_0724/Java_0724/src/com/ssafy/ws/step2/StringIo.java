package com.ssafy.ws.step2;

import java.util.Arrays;
import java.util.Scanner;

public class StringIo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String[] str = new String[size];

		for(int i = 0; i < size; i++) {
			str[i] = sc.next();
		}
		
		Arrays.stream(str).forEach(n->System.out.println(n));
		
	}

}
