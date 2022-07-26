package com.ssafy.live4.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapTest {
	//<String, String>을 저장하는 Map인터페이스, 구현체는 HashMap
    Map<String, String> hMap = new HashMap<>();

    private void addMethod() {
        System.out.println("추가 성공?: " + hMap.put("andy", "1234"));
        // 동일한 키의 사용 결과는?
        System.out.println("추가 성공?: " + hMap.put("andy", "4567"));
        hMap.put("kate", "9999");
        // 기존에 해당 키에 대한 값이 없을 때만 추가하기
        hMap.putIfAbsent("kate", "1234");

        hMap.put("henry", "4567"); // 동일한 값
        
        hMap.put("hong", "1234");
        System.out.println("추가 결과: " + hMap);
    }

    private void retrieveMethod() {
        // TODO: kate의 전화번호가 있나요?
    	//containsKey메서드는 대소문자 구분하므로 확인하기
    	System.out.println("Kate의 번호가 있나요?" + hMap.containsKey("kate"));
        // END:

        // TODO: map이 가지고 있는 key와 거기에 연결된 value를 출력하시오.
    	//key값들을 set으로 받는다.
    	Set<String> keys = hMap.keySet();
    	for(String key : keys) {
    		System.out.printf("key : %s, value: %s \n", key, hMap.get(key));
    	}
        // END:

        // TODO: 값이 4567인 사람의 이름은?
    	Set<Map.Entry<String, String>> entrySet = hMap.entrySet();
    	for(Map.Entry<String, String> entry : entrySet) {
    		if(entry.getValue().equals("4567")) {
    			System.out.println("번호가 4567인 사람? " + entry.getKey());
    		}
    	}
        // END:
    }

    private void removeMethod() {
        // TODO: andy의 자료를 삭제하고 출력하시오.
    	hMap.remove("andy");
    	System.out.println(hMap);
        // END:
    }

    public static void main(String[] args) {
        MapTest hmt = new MapTest();
        hmt.addMethod();
        hmt.retrieveMethod();
        hmt.removeMethod();
    }
    
}
