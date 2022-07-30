package com.example.polymorphism;

public class CastingTest1 {

	public static void main(String[] args) {
		Car car1 = null;
		FireEngine fireEngine1 = new FireEngine();
		FireEngine fireEngine2 = null;
		
		fireEngine1.water();//자신의 클래스의 메서드 호출했으므로 가능O
		
		car1 = fireEngine1;
		
		car1.drive();//가능O
		//car1.water(); //Car타입의 참조변수로는 FireEngine 인스턴스의 water()을 호출할 수 없음
		
		fireEngine2 = (FireEngine)car1;
		fireEngine2.water();
		
		System.out.println("참조변수가 가리키고 있는 인스턴스의 이름 : " + fireEngine2.getClass().getName());
		
		Car c1 = new Car();
		FireEngine f1 = new FireEngine();
		
		if(f1 instanceof Object) {
			System.out.println("Object 인스턴스");
		}
		
		if(f1 instanceof Car) {
			System.out.println("Car 인스턴스");
		}
		
		
	}

}

class Car{
	String color;
	int door;
	
	void drive() {//운전하는 기능
		System.out.println("drive, Brrr~~");
	}
	
	void stop() {//멈추는 기능
		System.out.println("stop!!!");
	}
	
}

class FireEngine extends Car{//소방차
	
	void water() {//물 뿌리는 기능
		System.out.println("water!!!!");
	}
	
}
