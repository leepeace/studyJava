package com.ssafy.ws.step3;


/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		
		Book book1 = new Book();
		Book book2 = new Book("35355","분석설계      ", "소나무", "jaen.kr", 30000,"SW 모델링");
		book1.setAuthor("김하나");
		book1.setDesc("Java 기본 문제");
		book1.setIsbn("21424");
		book1.setPrice(15000);
		book1.setPublisher("jaen.kr");
		book1.setTitle("Java Pro");
		
		Magazine magazine = new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",2021,1);
		
		//객체를 받아옴
		IBookManager bookManager = BookManagerImpl.getInstance();
		
		bookManager.add(magazine);
		bookManager.add(book1);
		bookManager.add(book2);
		bookManager.add(new Book("21425","Java Pro2", "김하나","Jaen.kr", 25000,"Java 응용"));
		
		System.out.println("****************도서 전체 목록**********************");
		for(Book book : bookManager.getList()) {
			System.out.println(book);
		}
		System.out.println("****************일반 도서 목록**********************");
		for(Book book : bookManager.getBooks()) {
			System.out.println(book);
		}
		System.out.println("****************잡지 목록**********************");
		for(Magazine showMagazine : bookManager.getMagazines()) {
			System.out.println(showMagazine);
		}
		System.out.println("****************도서 제목 포함 검색:Java **********************");
		for(Book book : bookManager.searchByTitle("Java")) {
			System.out.println(book);
		}
		System.out.println("도서 가격 총합 : " + bookManager.getTotalPrice());
		System.out.println("도서 가격 평균 : " + bookManager.getPriceAvg());
	
	}
}
