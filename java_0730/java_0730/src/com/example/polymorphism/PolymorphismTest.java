 package com.example.polymorphism;

public class PolymorphismTest {

	public static void main(String[] args) {
		
		//1. 업캐스팅
		//참조변수 t1이 다룰 수 있는 멤버의 개수가 실제 인스턴스(new CaptionTv();)가 갖고 있는 멤버의 개수보다 적기 때문에 형변환이 생략가능함
		Tv t1 = new CaptionTv();//조상타입의 참조변수로 자식인스턴스를 참조함
		
		//TV타입의 참조변수로는 CaptionTv 인스턴스 중에서 Tv 클래스의 멤버들만 사용할 수 있음
		//t1.caption();

		//컴파일 에러
		//실제 인스턴스인 Tv의 멤버 개수보다 참조변수 c1이 사용할 수 있는 멤버 개수가 더 많기 때문임
		//TV인스턴스에는 Caption 클래스의 text 변수와 caption() 메서드가 존재하지 않기 때문임
		//CaptionTv c1 = new Tv();
		
		//실제 인스턴스의 멤버 개수보다 참조변수가 사용할 수 있는 멤버의 개수가 더 많아지므로 문제가 발생할 가능성이 있다.
		//따라서, 형변환을 생략할 수 없다.
		CaptionTv c1 = (CaptionTv)t1;
		c1.caption();//가능 O
		
		
		//참조변수의 타입을 변환하는 것이지 인스턴스를 변환하는 것은 아니기 때문에 참조변수의 형변환은 인스턴스에 아무런 영향을 미치지 않음
		//CaptionTv c2 = (CaptionTv)new Tv();
		
		CaptionTv c3 = new CaptionTv();
		if(c3 instanceof Tv) {
			Tv t2 = c3;	
			System.out.println("형변환이 가능하다.");
		}
		
		
	}

}
