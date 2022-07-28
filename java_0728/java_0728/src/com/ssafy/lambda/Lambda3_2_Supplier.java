package com.ssafy.lambda;

import java.util.function.Supplier;

/*
 * Supplier<T> : 매개변수 없이 반환값만 갖는 함수형 인터페이스
 * 공급자(파라미터X, 리턴 O)
 * T get() 추상메서드 가짐
 * */
public class Lambda3_2_Supplier {
	
	public void useSupplier(Supplier<String> sup) {
		System.out.println(sup.get());
	}
	
	public static void main(String[] args) {
		Lambda3_2_Supplier supT = new Lambda3_2_Supplier();
		
		//T에 지정한 값이 리턴값의 형태가 됨
		Supplier<String> sup = ()->{return "Hello"; };
		//return String
		String str = sup.get();
		System.out.println(str);
		
		//인스턴스화하여 매개 값으로 넣을 수 있음
		supT.useSupplier(sup);
		
		//직접 람다식을 넣어도 무관
		supT.useSupplier(()->{return "Lambda";});
		//{}과 return 생략도 가능(코드 한 줄이라서)
		supT.useSupplier(()->"World");
	}

}
