package com.example.print;

/*
 * 1. print() 메서드에서 객체를 출력시 결과값을 알아본다.
 * 2. toString()에 대해서 알아본다.
 * */
public class PrintTest {
	
	public static void main(String[] args) {

		Student s = new Student();
		
		//toString() 생략 가능함
		/* Object.toString()이 호출됨
		 * 
		 * public String toString() {
         *		return getClass().getName() + "@" + Integer.toHexString(hashCode());
         * }
		 * */
		System.out.println("toString() 생략 : " + s);
		System.out.println(s.toString());
		
		
		System.out.println("-------- toString() 오버라이딩 ---------");
		
		Product p = new Product();
		
		//Object 클래스의 toString()메서드를 오버라이딩한 경우 
		//Product.toString()을 호출 
		System.out.println("toString() 생략 : " + p);
		System.out.println(p.toString());
		
	}
	
}
class Product{
	int price;
	int bonusPoint;
	
	public Product() {
		
	}
	
	//Object클래스의 toString() 메서드 오버라이딩
	@Override
	public String toString() {
		return "Product의 오버라이딩한 toString() 출력";
	}
	
}

class Student{
	int name;
	int age;
	
	public Student() {
	
	}
	
}
