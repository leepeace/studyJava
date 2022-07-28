package com.ssafy.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
 * Predicate<T> : 객체 T를 매개변수로 받아 처리한 후 Boolean을 반환
 * (파라미터O, 리턴O, Boolean고정)
 * Boolean test(T t)를 추상메서드로 가짐
 * 
 * */
public class Lambda3_4_Predicate {

	static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	public static void printSome(IntPredicate pred) {
	
		for (int num : nums) {
	
			if (pred.test(num)) {
				System.out.print(num + "\t");
			}
		}
		System.out.println();
		
	}
	public static void main(String[] args) {

		printSome((num) -> {
			return num % 3 == 0;});
		printSome(num -> num > 5);

	}
}
