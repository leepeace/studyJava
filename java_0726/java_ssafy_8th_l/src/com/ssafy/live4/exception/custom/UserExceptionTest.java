package com.ssafy.live4.exception.custom;


public class UserExceptionTest {
    private static String[] fruits = {"사과", "오렌지", "토마토"};

    public static void main(String[] args) {
        boolean result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        result = getFruit1("사과");
        if (!result) {
            System.out.println("사과는 없습니다.");
        }
        // TODO: 2. getFruit2를 이용해서 오렌지 2개를 소비해서 예외 상황을 테스트 하시오.
        try {
			getFruit2("오렌지");
			getFruit2("오렌지");
		} catch (FruitNotFoundException e) {
			System.out.println("오렌지 품절 다른 과일로 구매해주세요!");
		}
        // END:
        
        // TODO: 4. 수박, 멜론, 복숭아을 저장해서 예외 상황을 테스트 하시오.
        try {
			setFruit("수박");
			setFruit("멜론");
			setFruit("복숭아");
		} catch (Exception e) {
			e.printStackTrace();
		}
        // END:
        System.out.println("창고 관리 끝~");
    }

    private static boolean getFruit1(String name) {
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null && fruits[i].equals(name)) {
                fruits[i] = null;
                return true;
            }
        }
        return false;
    }

    // TODO: 1. getFruit1을 참조하여 예외를 활용하는 형태로 getFruit2를 작성하시오.
    private static void getFruit2(String name) throws FruitNotFoundException{
    	for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] != null && fruits[i].equals(name)) {
                fruits[i] = null;
                return;
            }
    	}
    	//여기까지 코드가 온 경우는 과일이 없는 경우
    	//->Exception 발생시킬 수 있음
    	throw new FruitNotFoundException(name);
    }
    
    // END:

    // TODO: 3. 배열의 null인 지점에 과일을 저장하도록 작성하시오.
    private static void setFruit(String name) {
    	for(int i = 0; i < fruits.length; i++) {
    		if(fruits[i] == null) {
    			fruits[i] = name;
    			return;
    		}
    	}
    	//여기까지 코드가 내려온 경우 창고에 공간이 없다는 이야기이다. 
    	throw new NoSpaceException(name);
    }
    // END:
    
}
