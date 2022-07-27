package com.ssafy.mms.model;

/**
 * 9.추가 할인율 discount
 * 10.담당자   manager
 * @author multicampus
 *
 */
public class MemberVip extends Member {
	private String manager;
	private int discount;
	
	public MemberVip() {
		super();
		this.manager="미정";
		this.discount=10;
	}
	
	public MemberVip(Member dto) {
		super(dto.getMemberId(), dto.getMemberPw(), dto.getName(), dto.getPhone(), dto.getAddr(),dto.getEmail(), dto.getEntryDate(),"VIP", dto.getMileage());
		this.manager="미정";
		this.discount=10;
	}
	
	@Override
	public String getInfo() {
		return this.getMemberId() + ", " + this.getGrade() + ", vip회원입니다.";
	}
	
	static public void getDynamic() {
		System.out.println("memberVip 정적 바인딩 테스트");
	}
	
	@Override
	public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("\t|     ");
			sb.append(manager);
			sb.append("\t|     ");
			sb.append(discount);
			
			return sb.toString();
	}
	
	
	
	
	
}
