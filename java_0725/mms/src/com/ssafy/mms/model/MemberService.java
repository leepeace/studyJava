package com.ssafy.mms.model;

import java.util.Arrays;

/**
 * DB대신 회원 정보를 저장할 객체 배열 포함(원래는 DAO의 역할)
 * + 회원 가입, 탈퇴, 수정 등등 요청 처리 역할을 담당한다
 * 
 * singletone 패턴 적용 --> 함부로 객체를 생성하지 못하도록 제한
 * 1. 클래스 생성자들을 private으로 만듬
 * 2. 클래스 내부에서 직접 생성
 * 3. getter를 통해 외부에 제공
 */
public class MemberService {
	/**
	 * 회원 자료 저장 구조 : 객체 배열, private
	 */
	private Member[] members;
	/**
	 * 등록한 회원 숫자 정보를 담는 멤버 변수
	 */
	private int count;
	
	//외부에서 함부로 객체 생성을 하지 못하도록 막음
	private MemberService(int length) {
		members = new Member[length];
	}
	
	/*
	 * 기본 배열 크기 8로 default 생성자 설정
	 * */
	private MemberService() {
		this(8);
	}
	
	private static MemberService memberService = new MemberService();
	
	public static MemberService getInstance() {
		return memberService;
	}
	
	public void addMemeber(Member dto) {
//		int exist =-1;
//		for(int i=0; i<count; i++) {
//			if(members[i].getMemberId().equals(dto.getMemberId())) {
//				exist=i;
//				break;
//			}
//		}
		
//		if(exist==-1) {
		if(exist(dto.getMemberId())==-1) {
			members[count++]=dto;
		}else {
			//원래는 exception이나 에러를 결과로 반환해야하지만, 아직 exception 진행 안해서 대신 print
			System.out.println("[오류발생!!]등록하려는 아이디가 이미 등록되어 있습니다.  ");
		}
		
		
	}
	
	/**
	 * 회원 아이디가 객체 배열에 있는지 존재여부 검사 
	 * @see java.lang.String #equals(Object)
	 * @param memberId
	 * @return 일치하는 아이디 존재하면 i인덱스 번호, 미존재하면 -1
	 */
	public int exist(String memberId) {
		for(int i=0; i<count; i++) {
			if(members[i].getMemberId().equals(memberId)) {
				return i;
			}
		}
		return -1;
	}
	
	//현재 등록된 회원수 반환 메서드
	public int getCount() {
		return count;
	}
	
	/**
	 * 전체 회원 조회
	 * @return 회원 타입 배열
	 */
	public Member[] getMemberList() {
		
//		return members;
		
		Member[] currentMembers = new Member[count];
		
		
		//새로운 배열에다가 정보가 있는 회원만큼 저장
		for(int i = 0; i< currentMembers.length; i++) {
			if(members[i].getGrade()!=null && members[i].getGrade().equals("S")) {
				changeToVip(members[i]);
			}
			currentMembers[i]=members[i];
		}
		
		return currentMembers;
	}
	/**
	 * 회원의 dto를 받아서 vip 회원으로 등업 처리
	 * @param dto
	 */
	public void changeToVip(Member dto) {
		int index = exist(dto.getMemberId());
		if(index>=0) {
			members[index]=new MemberVip(dto);
			System.out.println("[안내] "+ dto.getMemberId()+"님은 VIP회원이 되었습니다. ");
			
		}else {
			System.out.println("[오류]전환할 회원이 없어요 ㅜㅜ");
		}
	}
	
	
	
	/**
	 * arraycopy(복사할 obj, 시작위치 idx, 복사하려는 obj, 시작 idx, 데이터의 길이)
	 * @see java.lang.System #arraycopy(Object, int, Object, int, int)
	 * 
	 * @return
	 */	
	public Member[] getMemberList2() {
		Member[] currentMembers = new Member[count];
		System.arraycopy(members, 0, currentMembers, 0, count);
		return currentMembers;
	}
	
	/**
	 * @see java.util.Arrays #copyOf(Object[], int)
	 * @return
	 */
	public Member[] getMemberList3() {
		return Arrays.copyOf(members, count);
	}
	
	
	
	
	public Member updateMember(Member dto) {
		int index = exist(dto.getMemberId());
		if(index>=0) {
			Member dto2 =members[index];
			members[index]=dto;
			return dto2;
		}
		return null;		
	}
	
	public void updateMember(String memberId, String memberPw, String modifyMemberPw) {
		int index = exist(memberId);
		if(index>=0) {
			if(members[index].getMemberPw().equals(memberPw)) {//기존 암호와 같으면 변경
				members[index].setMemberPw(modifyMemberPw);
				System.out.println("[성공] 비밀번호가 정상 변경 처리 되었습니다.!!");
				return;
			}
		}
		System.out.println("[오류] 정보가 올바르지 않습니다!! 확인해주세요. ");
	}
	
	/**
	 * 회원 상세 조회
	 * @param memberId
	 * @return 존재하면 회원 객체 , 미존재하면 null 
	 */
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if(index>=0) {
			return members[index];
		}
		return null;
	}

}
