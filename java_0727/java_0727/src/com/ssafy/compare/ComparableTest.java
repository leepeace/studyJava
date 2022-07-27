package com.ssafy.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * 
 * @author multicampus
 *
 */
public class ComparableTest {
	
	private static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return -(o1.no - o2.no);
		}
		
	}
	
	public static void main(String[] args) {
		Student[] student = new Student[] {
				new Student(1, 10),
				new Student(5, 30),
				new Student(6, 0),
				new Student(2, 75),
				new Student(15, 15),
		};
		
		System.out.println("=======정렬 전=======");
		System.out.println(Arrays.toString(student));
		
		Arrays.sort(student);
		System.out.println("=======정렬 후, 객체에 Comparable =======");
		System.out.println(Arrays.toString(student));
		
		System.out.println("========Comparator 사용, 학번 내림차순===========");
		Arrays.sort(student, new StudentComparator());
		System.out.println(Arrays.toString(student));
		
		System.out.println("========Comparator 일회성, 점수 내림차순============");
		Arrays.sort(student, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				
				return 0;
			}
			
		});
		
		
		
	}
	
}
