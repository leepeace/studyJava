package com.example.access;

/*
 * 부모 클래스를 상속받은 자식클래스의 접근제한자 범위는 더 좁게 정할 수 없다!!
 * 자식 클래스의 접근 제한자의 범위는 같거나 더 커야한다.
 * -> 다형성
 * 리스코프 치환 원칙을 위배함(리스코프 치환 원칙 : 하위타입은 상위타입을 대체할 수 있어야 한다.)
 * */
public class AccessModifierTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat();
		
		Animal animal = new Animal();
		animal.eat();
	}

}

class Animal{
	
	public void eat() {
		System.out.println("동물이 먹는다!!");
	}
	
}

class Dog extends Animal{
	
	@Override
	public void eat() {
		System.out.println("강아지가 먹는다!!");
	}
	
}