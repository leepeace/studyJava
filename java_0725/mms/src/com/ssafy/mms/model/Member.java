package com.ssafy.mms.model;

/**
 * 회원 도메인 클래스(회원 정보를 전달하는 역할)
 * -- DTO(Data Transfer Object) : Pattern 기반 설계
 * -- Encapsulation : 멤버변수 private로 접근 제한/ getters&setters로 접근 통로 열어줌(주도권은 object가 가짐)
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 전화번호
 * 5. 주소
 * 6. 이메일
 * 7. 가입일
 * 8. 등급 :일반(G), 우수(S)- 마일리지 주기, 관리자(A)
 * 9. 마일리지
 * @author multicampus
 *
 */

public class Member {
	
	private String memberId;
	private String memberPw;
	private String name;
	private String phone;
	private String addr;
	private String email;
	private String entryDate;
	private String grade;
	private int mileage;
	
	public Member() {};
	
	/**
	 * 회원 가입시 사용자 입력데이터 초기화 생성자 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param phone 전화번호
	 * @param addr 주소 
	 * @param email 이메일
	 */
	public Member(String memberId, String memberPw, String name, String phone, String addr, String email) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
	}
	
	
	/**
	 * 로그인 시 사용하는 초기화 생성자
	 * @param memberId 아이디 
	 * @param memberPw 비밀번호
	 */
	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	
	
	

	/**
	 * 회원 전체 속성 초기화 생성자
	* @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param phone 전화번호
	 * @param addr 주소 
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param mileage 마일리지
	 */
	public Member(String memberId, String memberPw, String name, String phone, String addr, String email,
			String entryDate, String grade, int mileage) {
		this(memberId, memberPw, name, phone, addr, email);
		this.grade=grade;
		this.entryDate = entryDate;
		this.mileage = mileage;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		//검증 로직:
		if(isMemberId(memberId)) {
		this.memberId = memberId;
		}else {
			System.out.println("[오류] 아이디는 4자리에서 10자리 이내로 변경해주세요.");
		}
	}
	//valid()
	private boolean isMemberId(String memberId) {
		if(memberId.length()>= 4 && memberId.length()<=10) {
			return true; 
		}
		return false;
	}
	
	
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		if(isMemberPw(memberPw)) {
		this.memberPw = memberPw;
		}else {
			System.out.println("[오류] 비밀번호는 4자리에서 20자리 이내로 변경해주세요.");
		}
	}
	
	private boolean isMemberPw(String memberPw) {
		if(memberPw.length()>= 4 && memberPw.length()<=20) {
			return true; 
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	/*
	 * 메서드의 다형성
	 * 동적 바인딩(non-static) vs 정적바인딩(static)
	 * */
	public String getInfo() {
		return memberId + " ," + grade + ", 일반회원입니다.";
	}
	
	static public void getDynamic() {
		System.out.println("member 객체 정적 바인딩 테스트");
	}
	
	
	//StringBuilder 활용한 toString 변경
	/**
	 * 1. StringBuilder 객체 만들기
	 * 2. append() 메소드를 통해 문자열 추가
	 * 3. 완성 됐으면 toString으로 출력 가능
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(memberId);
		sb.append("\t|     ");
		sb.append(memberPw);
		sb.append("\t|     ");
		sb.append(name);
		sb.append("\t|     ");
		sb.append(phone);
		sb.append("\t|     ");
		sb.append(addr);
		sb.append("\t|     ");
		sb.append(email);
		sb.append("\t|     ");
		sb.append(grade);
		sb.append("\t|     ");
		return sb.toString();
		
	}
	
	
	
	
	
	/**
	 * String 객체는 변경이 불가능 하다. ==> 한번 생성하면 내용을 바꿀 수 없음
	 * why? 1. String Pool = String 타입 사용이 빈번하여 존재. 
	 * 			String 객체를 새로 생성하기 보다 값이 같은 String이면 재사용할 수 있도록 구현
	 * 			String이 변하면 같은 문자열을 참조하는 두개의 변수가 있다면 한쪽은 알 수 없음(위험!!!!)
	 * 		2. 보안. 위의 말과 일맥상통하는 부분이 있음. 
	 * 			메서드의 파라미터로도 String을 많이 사용하는데 (ID,pw, name, 네트워크 연결 정보 등등) 
	 * 			이 파라미터를 인자로 받아 호출하면서 바꾸는 행위 등의 취약점이 많음
	 *      3. 동기화 = 멀티 스레드 환경에서 String을 사용하는 경우 값이 바뀌면 위험이 더욱 커진다. 
	 *      등등 결국 전체적으로 불변한 상태가 유리하여 String은 immutable(불변) 하게 설계 됨
	 */
//	@Override
//	public String toString() {
//		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", phone=" + phone
//				+ ", addr=" + addr + ", email=" + email + ", entryDate=" + entryDate + ", grade=" + grade + ", mileage="
//				+ mileage + "]";
//	}
//	
	
	

}
