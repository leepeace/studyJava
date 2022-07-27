package com.ssafy.test;

/*
 * 월말평가 1번 : 정삼각형 출력의 경우에 대하여 풀지못함
 		A
	  B C D
	E F G H I
  J K L M N O P 
Q R S T U V W X Y 
  
 * */
public class Test01 {

	public static void main(String[] args) {
	
		char alphabet = 'A';
		for(int i = 0; i < 5; i++) {
			//공백 출력
			for(int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			
			//알파벳 출력
			for(int k = 0; k < i*2+1; k++) {
				System.out.print(alphabet);
				alphabet++;
			}
			System.out.println();
		}	
	}

}
//공백이 4, 3, 2, 1, 0 개수로  진행됨
//알파벳은 1, 3, 5, 7, 9 개수로 진행됨