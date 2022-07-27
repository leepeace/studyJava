package com.ssafy.live3.abs;

public abstract class Vehicle {
	private int curX, curY;
	
    public void reportPosition() {
        System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName(), curX, curY);
    }
	
    //자손클래스에서 반드시 재정의해서 사용되기 때문에 조상의 구현이 무의미한 메서드
	/*	public void addFuel() {
		    System.out.printf("운송수단은 연료가 필요하지");
		}*/
	public abstract void addFuel();
	
}
