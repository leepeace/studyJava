package com.ssafy.ws.step3;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	//public abstract이 생략 가능하다.
	public abstract void add(Book book);
	
	void remove(String isbn);
	
	Book[] getList();
	
	Book searchByIsbn(String isbn);
	
	Book[] searchByTitle(String Title);
	
	Book[] getBooks();
	
	Magazine[] getMagazines();

	int getTotalPrice();
	
	double getPriceAvg();

}
