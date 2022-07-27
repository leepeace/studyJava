package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolySpiderTest {

	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan("피터파커", true);
		
		//다형성
		SpiderMan sman2 = sman;//가능
		Person person = sman;//조상을 통해 자식을 참조
		Object obj = person;//가능
		
		//명시적 형 변환
		SpiderMan reSpider = (SpiderMan)obj;
		reSpider.fireWeb();
		
		
		//뭐든지 담을 수 있는 만능의 주머니
		Object[] objs = new Object[4];
		objs[0] = sman;
		objs[1] = "Hello";
		objs[2] = objs;
		//기본형인데 Object배열에 담아지는 이유는??
		//Integer라는 Wrapper클래스로 담아져서
		//->이것을 autoboxing이라고 한다.
		objs[3] = 1;
		
		SpiderMan fromObjArray = (SpiderMan)objs[0];
		fromObjArray.fireWeb();
		
		//SpiderMan fromobjArray2 = (SpiderMan)objs[1];
		//fromobjArray2.fireWeb();
		if(objs[1] instanceof SpiderMan) {
			SpiderMan fromobjArray2 = (SpiderMan)objs[1];
			fromobjArray2.fireWeb();
		}
		for(Object o : objs) {
			System.out.println(o.getClass().getName());
		}
		
		//println(Object x)
		System.out.println(sman2);
		System.out.println(person);
	}

}
