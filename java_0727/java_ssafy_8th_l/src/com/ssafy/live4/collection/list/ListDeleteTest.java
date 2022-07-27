package com.ssafy.live4.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListDeleteTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        System.out.println("전체: " + nums);
        // TODO: 3의 배수인 요소들을 삭제해보자.
        //forEach문장에서 Collection크기가 불변해야 함!
        //에러 발생
/*        for(Integer i : nums) {
        	if(i % 2 == 0) {
        		nums.remove(i);
        	}
        }*/
        for(int i = nums.size()-1; i >= 0; i--) {
        	if(nums.get(i) % 3 == 0) {
        		nums.remove(i);
        	}
        }
        // END:
        System.out.println("3의 배수 삭제 후: " + nums);

        // TODO: 3n+1인 요소들을 삭제해보자.
        
        // END:
        System.out.println("3n+1 삭제 후: " + nums);
        
        // TODO: 3n+2인 요소들을 삭제해보자.
      
        // END:
        System.out.println("3n+2 삭제 후: " + nums);
        
        List<String> strs = Arrays.asList("Hello", "Collection", "World");
        // TODO: strs에 자료를 추가, 수정, 삭제해보자.
        //크기가 변하면 안되기 때문에 에러
        //strs.add("Hi");
        //strs.remove(0);
        strs.set(0, "Haahahaha");//크기 변경하는 경우가 아니라면 사용할 수 있음
        // END:
        System.out.println(strs);
    }

}
