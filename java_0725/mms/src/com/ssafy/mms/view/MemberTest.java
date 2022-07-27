package com.ssafy.mms.view;

import com.ssafy.mms.model.Member;
import com.ssafy.mms.model.MemberService;
import com.ssafy.mms.model.MemberVip;

public class MemberTest {

	public static void main(String[] args) {
		//회원가입
		Member dto1 = new Member("user01", "password01", "홍길동", "010-1234-1234", "광주 광역시 ", "aaa@ssafy.com");
		
		//전체 초기화
		Member dto2 = new Member("user02", "password02", "강감찬", "010-2222-2222", "광주 광역시 ", "aaa@ssafy.com", "2022.07.22","G", 1000);
		Member dto3 = new Member("user03", "password03", "강감찬3", "010-3333-3333", "광주 광역시 ", "aaa@ssafy.com", "2022.07.22","S", 0);
		Member dto4 = new Member("user04", "password04", "강감찬2", "010-4444-4444", "광주 광역시 ", "aaa@ssafy.com", "2022.07.22","A", 0);
		Member dto5 = new Member("user04", "password05", "강감찬2", "010-4444-4444", "광주 광역시 ", "aaa@ssafy.com", "2022.07.22","A", 0);
	
		//요청 처리를 위한 서비스 객체 생성
		//MemberService service = new MemberService();
		MemberService service = MemberService.getInstance();
		
		print("-------------1.회원등록----------");
		service.addMemeber(dto1);
		service.addMemeber(dto2);
		service.addMemeber(dto3);
		service.addMemeber(dto4);
		service.addMemeber(dto5);
		
		System.out.println("현재 가입한 회원 수 : "+ service.getCount());
		System.out.println("--------전체 회원 조회------------");
		Member[] members = service.getMemberList();
		for(int i=0; i<service.getCount(); i++) {
			System.out.println(members[i]);
		}
		
		print("--------------3.회원 정보 변경--------------");
		Member dto= new Member("user03", "happyday", "김다올","광주 광역시", "010-0000-0000", "daol@ssafy.com", "22.07.22","G", 0);
		Member result = service.updateMember(dto);
		print("변경 전 후 비교");
		print(result);
		print(service.getMember(result.getMemberId()));
		
		print("---------------4.비밀번호 변경------------");
		service.updateMember("user01", "password01", "hello2022");
		service.updateMember("user99", "password01", "hello2022");
		
		print(service.getMemberList());
		
		print("--------다형성----------");
		Member mem1 = members[2];//Member타입 변수에 memberVIP 객체 담기
		MemberVip mem2 = (MemberVip)members[2];
		
		//메서드의 동적 바인딩(in 다형성) : Runtime시점에 해당 메서드를 구현하고 있는 실제 객체 타입을 기준으로 찾아 실행 
		System.out.println(mem1.getInfo());
		System.out.println(mem2.getInfo());
		
		mem1.getDynamic();
		mem2.getDynamic();
		
	}
	//오버로딩!! 테스트를 위한 출력 메서드 중복 정의
	// -> 메서드 이름은 같음, 매개 변수의 타입이 다름 (매개변수의 개수가 달라도 됨)
	// 객체 생성 없이 사용하기 위한 static 메서드
	public static void print(String message) {
		System.out.println("-----"+message);
	}
	
	public static void print(Member dto) {
		System.out.println(dto);
	}
	
	public static void print(Member[] members) {
		for(Member dto : members) {
			System.out.println(dto);
		}
	}

}
