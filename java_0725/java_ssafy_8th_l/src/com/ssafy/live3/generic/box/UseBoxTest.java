package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
        NormalBox nbox = new NormalBox();
        //Object처리 -> 뭐든지 담을 수 있다.
        nbox.setSome(1);
        nbox.setSome("Hello");
        
        Object obj = nbox.getSome();
        //complie ok, but runtime error - runtime에 타입에 대한 체크
        //Integer num = (Integer)obj;
        if(obj instanceof String) {
        	String str = (String)obj;
        	System.out.println(str + " : " + str.length());
        }
        
        GenericBox<Object> obox = new GenericBox<Object>();
        
        
    	// END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sbox = new GenericBox<String>();
    	sbox.setSome("Hello");//complie시점에 타입에 대한 체크
    	String str = sbox.getSome();
    	System.out.println(str + " : " + str.length());
    	
    	GenericBox<Integer> ibox = new GenericBox<Integer>();
    	ibox.setSome(1);
    	
    	// END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        NumberBox<Number> numbox = new NumberBox<Number>();
        numbox.addSome(1, 10l, 3.14);
        
        NumberBox<Integer> dbox = new NumberBox<Integer>();
        numbox.addSome(1, 2, 101);
    	// END:
    }

}
