package com.ssafy.live2.extend.person;

public class SpiderManTest {
	
	//static이므로 객체를 따로 생성해서 호출하지 않아도 됨
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		int i  = 10;
		
		SpiderMan sman = new SpiderMan("피터파커", false);
		sman.eat();//person
		sman.jump();//person
		sman.fireWeb();//spiderman
		
		sman.isSipder = true;
		
		sman.eat();//person
		sman.jump();//person
		sman.fireWeb();//spiderman
		sman.love();
		
		System.out.println(sman.toString());
	}

}
