package com.ssafy.ws.step3;

import java.util.Arrays;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	private static final int MAX_SIZE = 100;//관리할 최대 도서의 개수
	private int size = 0;
	private Book[] books = new Book[MAX_SIZE];
	
	//도서 등록 메서드
	public void add(Book book) {
		if(size < MAX_SIZE){
			books[size++] = book;
		}
	}
	
	//도서 삭제 메서드
	public void remove(String isbn) {
		for(int i = 0; i < size; ++i) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[--size];
				books[size] = null;
				break;
			}
		}
	}
	
	public Book[] getList() {
		//return this.books;
		return Arrays.copyOfRange(books, 0, size);
	}

	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	public Book[] searchByTitle(String title) {
		Book[] temp = new Book[MAX_SIZE];
		int index = 0;
		for(int i = 0; i < size; i++) {
			if(books[i].getTitle().contains(title)) {
				temp[index++] = books[i];
			}
		}
		
		return Arrays.copyOfRange(temp, 0, index);
	}
	
	//잡지의 경우
	public Magazine[] getMagazines() {
		
		int index = 0;
		Magazine[] magazineUser = new Magazine[MAX_SIZE];
		for(int i = 0; i < size; i++) {
			if(books[i] instanceof Magazine) {
				magazineUser[index++] = (Magazine)books[i];
			}
		}
		return Arrays.copyOfRange(magazineUser, 0, index);
	}
	
	//일반 도서의 경우
	public Book[] getBooks() {
		int index = 0;
		Book[] bookUser = new Book[MAX_SIZE];
		for(int i = 0; i < size; i++) {
			if(!(books[i] instanceof Magazine)) {
				bookUser[index++] = books[i];
			}
		}
		return Arrays.copyOfRange(bookUser, 0, index);
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}
		return sum;
	}
	
	public double getPriceAvg() {
		int sum = getTotalPrice();
		double avg = getTotalPrice() / size;
		
		return avg;
	}
	
}
