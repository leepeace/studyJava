package com.ssafy.live4.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetTest {
    Set<Object> hset = new HashSet<Object>();

    private void addMethod() {
    	//값의 중복이 허용되지 않음
        hset.add(Integer.valueOf(1));
        hset.add("Hello");     
        hset.add("Hello");      // 동일한 데이터 추가 확인
        hset.add(1);            // 기본형은 wrapper를 통해 추가
        // TODO: SmartPhone 타입의 객체를 추가해보자.
    
        hset.add(new SmartPhone("010-1111-1111"));
        hset.add(new SmartPhone("010-1111-1111"));
        
        SmartPhone p1 = new SmartPhone("010-2222-1111");
        SmartPhone p2 = new SmartPhone("010-2222-1111");
        System.out.println("두 핸드폰은 같은가? " + p1.equals(p2));
        
        // END:
        System.out.println("데이터 추가 결과: " + hset);
    }

    private void retrieveMethod() {
        System.out.println("데이터 개수: " + hset.size());

        //iterator : set이 가지고 있는 요소들을 목록화해줌
        Iterator<Object> iter = hset.iterator();
        if(iter.hasNext()) {
        	System.out.println("iter : " + iter.next());
        }
        
        //JDK 1.5 추가
        for (Object sobj : hset) {
            System.out.println("데이터 조회: " + sobj);
        }
    }

    private void removeMethod() {
        hset.remove("Hello");
        System.out.println("데이터 삭제 결과: " + hset);
    }
    
    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.addMethod();
        test.retrieveMethod();
        test.removeMethod();
    }
    
    
}
