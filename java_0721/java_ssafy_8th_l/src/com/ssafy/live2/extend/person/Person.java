package com.ssafy.live2.extend.person;

public class Person {

	public String name = "피터파커";
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name){	
		this.name = name;
	}
	
	public void eat() {
		System.out.println("냠냠");
	}
	
	public void jump() {
		System.out.println("두 다리 폴짝!");
	}
	
	public void jump(String option) {
		
	}
	
	public String toString() {
		return "person:, name " + this.name;
	}
	
}
