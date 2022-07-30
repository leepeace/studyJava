package com.example.polymorphism;

public class BindingTest {
	
	public static void main(String[] args) {
		Parent parent = new Child();
		Child child = new Child();
		
		//메서드인 printNum()의 경우 참조변수의 타입에 관계없이 오버라이딩된 자식클래스의 printNum()을 호출한다.
		//하지만, 인스턴수 변수인 num은 자식 클래스에서 중복으로 정의된 경우에는 참조변수의 타입에 따라서 달라진다.
		System.out.println("parent.num = " + parent.num);
		System.out.println("child.num = " + child.num);
		
		System.out.println("----- print method---------");
		//메서드는 참조 타입과 무관하게 상속받은 메서드를 호출함
		parent.printNum();
		child.printNum();
		
	}
	
}

class Parent{
	int num = 100;
	
	//상속이 이루어지는 과정에서 상위 클래스의 생성자가 먼저 호출됨
	//super()이 호출되기 때문임
	//부모 클래스가 먼저 생성되어야 자식 클래스가 부모 클래스의 멤버를 사용할 수 있기 때문임
	public Parent() {
		System.out.println("Parent 생성자 호출");
	}
	
	void printNum() {
		System.out.println("Parent Method : " + num);
	}
	
}

class Child extends Parent{
	int num = 350;
	
	public Child() {
		//super();
		System.out.println("Child 생성자 호출");
	}
	
	@Override
	void printNum() {
		int num = 9000;//지역변수
		System.out.println("Child Method, num = " + num);//350
		System.out.println("Child Method, this.num = " + this.num);//350
		System.out.println("Child Method, super.num = " + super.num);//100
	}
	
}