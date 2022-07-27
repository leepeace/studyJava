package com.ssafy.ws.step3;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 3000, "SW 모델링");
		Book book3 = new Book("21425", "Java Pro2", "소나무", "jaen.kr", 25000, "SW 모델링");

		Magazine magazine1 = new Magazine("45678", "월간알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
		
		
		BookManager manager = new BookManager();
		
		manager.add(book1);
		manager.add(book2);
		manager.add(book3);
		manager.add(magazine1);
		
		System.out.println("******************도서 전체 목록******************");
		for(Book book : manager.getList()) {
			System.out.println(book);		
		}
		
		System.out.println("******************일반 도서 목록*******************");
		for(Book book : manager.getBooks()) {
			System.out.println(book);		
		}
		
		System.out.println("******************잡지 목록*******************");
		for(Magazine magazine : manager.getMagazines()) {
			System.out.println(magazine);		
		}
		
		System.out.println("******************도서 제목 포함검색: Java*******************");
		for(Book book : manager.searchByTitle("Java")) {
			System.out.println(book);
		}
		
	}

}
