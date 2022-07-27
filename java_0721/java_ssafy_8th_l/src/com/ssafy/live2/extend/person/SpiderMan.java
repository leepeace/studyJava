package com.ssafy.live2.extend.person;

public class SpiderMan extends Person{

	public boolean isSipder;
	Spider spider = new Spider();
	
	public SpiderMan() {
		// TODO Auto-generated constructor stub
	}
	
	public SpiderMan(String name, boolean isSpider) {
		super(name);
		this.isSipder = isSpider;
	}
	
	public void fireWeb() {
		if(isSipder) {
			spider.fireWeb();
		}else {
			System.out.println("사람일때는 참자!");			
		}
	}
	
	//자식이 코드를 개선하면 자동적으로 사용하는 곳에서는
	//개선된 코드가 동작한다.
	@Override
	public void jump() {
		if(isSipder) {
			spider.jump();
		}else {
			//System.out.println("두 다리 폴짝!");
			super.jump();
		}
	}
	
	@Deprecated
	public void love() {
		System.out.println("메리제인 사랑해!");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", isSpider : " + this.isSipder;
	}
	
}
