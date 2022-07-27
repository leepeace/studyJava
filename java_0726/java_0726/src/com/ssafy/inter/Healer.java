package com.ssafy.inter;

/*
 * 인터페이스
 * 	구현자 관점 : 동작 구현의 책임(How)
 * 	사용자 관점 : 사용방법 제공(What)
 * 	-> 사용과 구현의 분리
 * 클래스와 다르게 다중 상속 가능
 * 기존 단일 상속과 다르게 인터페이스의 경우 상속관계가 없더라도 공통의 관계부여->다형성 확장
 * */
public interface Healer {
	public void heal();
	
	//java8부터 디폴트  메서드, static메서드 사용 가능
	public default void buff() {
		System.out.println("지정 거리 안의 아군에게 공격력 10% 증가 효과 부여");
	}

}
