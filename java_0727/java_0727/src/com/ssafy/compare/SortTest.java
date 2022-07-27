package com.ssafy.compare;

import java.util.Arrays;


/**
 * Primitive type or Wrapper Class or String은 비교의 기준을 넣어주지 않아도 정렬됨
 * why? 이미 API에 compareTo라고 하는 것이 구현되어 있으며,
 * 오름차순으로 정렬되도록 만들어져있음
 * @author multicampus
 *
 */
public class SortTest {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {12, 8, 5, 4, 6, 1};
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		Arrays.sort(arr);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
		
		String[] city = {"대전", "광주", "서울", "부울경", "구미"};
		System.out.println("정렬 전 : " + Arrays.toString(city));
		Arrays.sort(city);
		System.out.println("정렬  후 : " + Arrays.toString(city));
		
	}

}
