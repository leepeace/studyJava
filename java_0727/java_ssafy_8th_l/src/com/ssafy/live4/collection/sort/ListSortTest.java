package com.ssafy.live4.collection.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.live4.collection.set.SmartPhone;

public class ListSortTest {

    private List<String> names = Arrays.asList("Hi", "Java", "World", "Welcome");

    public void basicSort() {
        // TODO: names를 이름의 오름차순, 또는 그 역순으로 정렬해서출력하시오.
    	Collections.sort(names);
    	System.out.println(names);
    	
    	Collections.reverse(names);
    	System.out.println(names);
    	
        // END:
    }

    public void sortPhone() {
        // TODO: 전화 번호에 따라 SmartPhone을 정렬해보자.
    	List<SmartPhone> phones = Arrays.asList(new SmartPhone("010"), new SmartPhone("011"), new SmartPhone("000"), new SmartPhone("111"));
    	
    	System.out.println(phones);
    	Collections.sort(phones);
    	System.out.println(phones);
        // END:
    }

    public void stringLengthSort() {
        // TODO: 문자열의 길이에 따라 names를 정렬해보자.
    	//외부에 Comparator를 만든 경우
    	Collections.sort(names, new StringLengthComparator());
    	
    	//익명 inner class : 일회성
    	Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}

		});
    	
        // END:
        System.out.println(names); // [World, Welcome, Hi, Java]
    }

    public static void main(String[] args) {
        ListSortTest st = new ListSortTest();
       //st.basicSort();
        st.sortPhone();
        st.stringLengthSort();
    }

}
