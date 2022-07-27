package com.ssafy.ws.step3;


/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		
		Book book1 = new Book("21424", "Java Pro2", "김하나", "jaen.kr", 15000, "Java 기본 문제", 10);
		Book book2 = new Book("35355","분석설계 ", "소나무", "jaen.kr", 30000,"SW 모델링", 20);
		
		
		Magazine magazine = new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",2021,1, 30);
		
		//객체를 받아옴
		IBookManager bookManager = BookManagerImpl.getInstance();
		
		bookManager.add(magazine);
		bookManager.add(book1);
		bookManager.add(book2);
		bookManager.add(new Book("21425","Java Pro2", "김하나","Jaen.kr", 25000,"Java 응용", 10));
		
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
		
		System.out.println("****************도서 가격 총합 & 도서 가격 평균 **********************");

		System.out.println("도서 가격 총합 : " + bookManager.getTotalPrice());
		System.out.println("도서 가격 평균 : " + bookManager.getPriceAvg());
	
		System.out.println("***************도서 판매 : 21424, 11개 **************");
		try {
			bookManager.sell("21424", 11);
		} catch (QuantityException e) {
			System.out.println("수량이 부족합니다.");
		}catch (ISBNNotFoundException e) {
			System.out.println("존재하지 않는 책입니다.");
			System.out.println("조회한 isbn번호는 ? " + e.getIsbn());
		}
		
		System.out.println("***************도서 구매 : 21424, 10개 **************");
		try {
			bookManager.buy("21424", 10);
			for(Book book : bookManager.getList()) {
				if(book.getIsbn().equals("21424")) {
					System.out.println(book.toString());
				}
			}
		}catch (ISBNNotFoundException e) {
			System.out.println("존재하지 않는 책입니다.");
		}
		
		System.out.println("***************도서 판매 : 21424, 11개 **************");
		try {
			bookManager.sell("21424", 11);
			for(Book book : bookManager.getList()) {
				if(book.getIsbn().equals("21424")) {
					System.out.println(book.toString());
				}
			}
		} catch (QuantityException e) {
			System.out.println("수량이 부족합니다.");
		}catch (ISBNNotFoundException e) {
			System.out.println("존재하지 않는 책입니다.");
		}
	}
}
