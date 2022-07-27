package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
    // END:
	private static SingletonClass sc = new SingletonClass();
	
	//stateless한 클래스 - 상태를 가지지 않고 기능만 가지고 있음
	private SingletonClass() {
		
	}
	
	public static SingletonClass getSingleTonClass() {
		return sc;
	}
	
    public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
      // TODO:SingletonClass를 사용해보세요.  
    	//SingletonClass sc = new SingletonClass();
    	//sc.sayHello();
    	
    	SingletonClass sc = SingletonClass.getSingleTonClass();
    	sc.sayHello();
    	
    	SingletonClass sc2 = SingletonClass.getSingleTonClass();
    	sc2.sayHello();
    	
    	System.out.println(sc == sc2);
    	
      // END:
    }
  }
