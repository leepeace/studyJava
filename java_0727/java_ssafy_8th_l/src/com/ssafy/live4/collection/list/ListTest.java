package com.ssafy.live4.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
    List<String> friends = new ArrayList<>();


    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    //CRUD 중 Create : 입력
    public void createTest() {
        // TODO: friends에 여러명의 친구를 등록해보자.
        friends.add("홍길동");//데이터 추가
        friends.add("장길산");//새로운 데이터 뒤에 append
        friends.add("홍길동");//순서가 있으므로 중복 허용
        friends.add("임꺼정");
        friends.add(0, "이몽룡");
        
    	// END:
        System.out.println("추가 후 내용 출력: " + friends);
    }

    //조회 - Read
    public void retrieveTest() {
        // TODO: 다양한 조회 기능을 사용해보자.
        //  혹시 비어있지는 않나? 요소의 개수는 ?
    	System.out.printf("비어있나? %b, 요소의 개수는? %d\n", friends.isEmpty(), friends.size());
        //  반복을 이용한 요소 순회
    	for(int i = 0; i < friends.size(); i++) {
    		System.out.println(" 인덱스 : " + i + "-" + friends.get(i));
    	}
    	
    	for(String name : friends) {
    		System.out.println(name);
    	}
    	
        //  홍길동이 있다면 그 위치 출력-> equals, contains 활용가능
/*    	for(int i = 0; i < friends.size(); i++) {
    		if(friends.get(i).equals("홍길동")) {
    			System.out.println("홍길동 위치 : " + i);
    		}
    	}
    	
    	for(int i = 0; i < friends.size(); i++) {
    		if(friends.get(i).contains("홍길동")) {
    			System.out.println("홍길동 위치 : " + i);
    		}
    	}*/
    	
    	if(friends.contains("홍길동")) {
    		//앞에서부터 search하여 인덱스 리턴
    		System.out.println("홍길동의 위치는 " + friends.indexOf("홍길동"));
    		//뒤에서부터 search하여 찾으면 인덱스 리턴
    		System.out.println("홍길동의 위치는 " + friends.lastIndexOf("홍길동"));
    	}
    	// END:
    	
    	List<String> sub = friends.subList(0, 2);
    	System.out.println("sub의 내용은 ? " + sub);
    	
    }

    //수정-Update
    public void updateTest() {
        // TODO: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
    	System.out.println("업데이트 전 : " + friends);
    	
    	for (int i = 0; i < friends.size(); i++) {
			if (friends.get(i).equals("홍길동")) {
				friends.set(i, "율도국 왕");
			}
		}
    	
    	System.out.println("업데이트 후 : " + friends);
        // END:
    }

    public void deleteTest() {
        
    	// TODO: 0번째 친구와 율도국 왕을 삭제하시오.
    	System.out.println("삭제 전 : " + friends);
    	friends.remove(0);
    	friends.remove("율도국 왕");
        // END:
    	
        System.out.println("삭제 후 : " + friends);
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
    }
    
}
