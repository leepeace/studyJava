package com.ssafy.lambda;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 람다식? 익명 함수를 생하기 위한 식(자바 코드가 간결해짐)
// 함수적 프로그랭밍이 필요한 이유? 병렬 처리와 이벤트 지향 프로그래밍에 적합
/*
 * 형태 : 매개변수를 가진 코드 블록
 * () -> {}
 */

public class Lambda1 {
   public static void main(String args[]){
   
      List<String> names1 = new ArrayList<String>();
      names1.add("Mahesh ");
      names1.add("Suresh ");
      names1.add("Ramesh ");
      names1.add("Naresh ");
      names1.add("Kalpesh ");
		
      List<String> names2 = new ArrayList<String>();
      names2.add("Mahesh ");
      names2.add("Suresh ");
      names2.add("Ramesh ");
      names2.add("Naresh ");
      names2.add("Kalpesh ");
		
      Lambda1 tester = new Lambda1();
      System.out.println("Sort using Java 7 syntax: ");
		
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("Sort using Java 8 syntax: ");
		
      tester.sortUsingJava8(names2);
      System.out.println(names2);
   }
   
   // Arrays의 Sort 메서드는 문자열을 비교할때, compare()메서드 사용
   //sort using java 7
   private void sortUsingJava7(List<String> names){   
      Collections.sort(names, new Comparator<String>() {
         @Override
         public int compare(String s1, String s2) {
            return s1.compareTo(s2);
         }
      });
   }
   

   //sort using java 8
   
   //람다식 적용하면 간결해짐
   // 객체가 필요한 자리에 코드 블록만 블록만 전달.
   // (파라미터,..)  -> {메서드 구현부}
   // 람다식은 런타임시에 익명의 내부 클래스로 변경돼서 처리되므로 동작은 동일
   private void sortUsingJava8(List<String> names){
	   Collections.sort(names, (s1, s2) -> s1.compareTo(s2) );
   }
   
   //위의 람다식을 다시 코드로 보자면?
//   Comparator<String> strComp = (s1, s2) -> {return s1.compareTo(s2);}
//   Arrays.sort(names, strComp);

}
