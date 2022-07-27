package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {4, 3, 7, 5, 1};
		
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	
		
	}
	
}
