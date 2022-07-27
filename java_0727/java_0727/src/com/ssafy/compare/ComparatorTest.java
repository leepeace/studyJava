package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	/*
	 * 2차원 배열의 정렬하려면?
	 * 단순한 오름차순/내림차순 정의외에 사용자가 원하는 형태에 비교값 반환 가능
	 * */
	private static class MyComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			int diff = -(o1[1] - o2[1]);//점수 내림차순
			//점수 비교했을때, 점수가 다르면 점수 내림차순, 점수가 같으면? 학번 내림차순
			if(diff == 0) {
				return -(o1[0] - o2[0]);
			}
			
			return diff;
			//return diff != 0 ? diff : o1[0]-o2[0];//점수 내림차순
		}
		
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,10},{9,52},{4,25},{2,22}, {3,52}};

		for(int[]  is :arr) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
		
		//여기서 원소는? int[]<- 얘는 크기 판단의 기준 아무것도 없음
		
		// 판단의 기준을 원소에게 맡길 수 없음, 판단의 기준인 Comparabtor 만들어서 줘야함
		Arrays.sort(arr, new MyComparator());
		for(int[]  is :arr) {
			System.out.println(Arrays.toString(is));
		}
		
		
	}


}
