package com.ssafy.ws.step3;

import java.util.Arrays;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	
	//관리할 최대 도서의 개수
	private static int MAX_SIZE = 100;
	private Book [] books = new Book[MAX_SIZE];
	private int size = 0;
	
	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size++] = book;
		}
		else {
			System.out.println("최대 사이즈를 넘었습니다.");
		}
	}
	
	
	public void remove(String isbn) {
		for(int i = 0; i<=size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				System.out.println("****************도서삭제 :" + isbn + "****************");
				for(int j = i+1; j<=size; j++) {
					books[j-1] = books[j];
				}
				books[size--] = null;
				break;
			}
		}
	}
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
		
	}
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)){
				System.out.println("****************도서조회 :" + isbn + "****************");
				return books[i];
			
			}
			
		}
		return null;
	}
	public Book[] searchByTitle(String Title){ //주어진 값이 포함된 제목으로 booklist 리턴
		int cnt = 0;
		for(int i = 0; i<size; i++){
			// 배열의 저장된 객체의 title 정보를 불러오기
			if (books[i].getTitle().contains(Title)){ // 주어진 값이 포함된다면 true
				cnt ++; // 주어진 값이 포함된 book 개수
			}
		}
		Book [] res = new Book[cnt]; //book 개수로 배열 생성
		int index = 0;
		for (int i = 0; i<size; i++) {
			if (books[i].getTitle().contains(Title)) {
				res[index++] = books[i]; 
			}
		}
		return res;
	}
	
	public Book[] getBooks() {
		int cnt = 0;
		for(int i = 0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) { //magazine 객체가 아니라면 true
			//Book으로 비교할시 magazine은 Book을 상속 받기 때문에 true가 나오게됨
				cnt ++; //magazine 객체가 아닌 book 객체의 개수
			}
		}
		Book[] res = new Book[cnt];
		int index = 0;
		for(int i = 0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) {
				res[index++] = books[i];
			}
		}
		return res;
	}
	
	public Magazine[] getMagazines() { 
		int cnt = 0;
		for(int i = 0; i<size; i++) {
			if(books[i] instanceof Magazine) { //magazine 객체라면 true
				cnt ++; // magazine 개수 추가
			}
		}
		Magazine[] res = new Magazine[cnt]; // magazine 객체 배열 cnt 값만큼 생성
		int index = 0;
		for(int i = 0; i<size; i++) {
			if(books[i] instanceof Magazine) {
				res[index++] = (Magazine)books[i];
			}
		}
		return res;
	}
	public int getTotalPrice() {
		int totalPrice = 0;
		for(int i = 0; i< size; i++) {
			totalPrice += books[i].getPrice(); // 모든 book의 가격을 더함
		}
		return totalPrice;
	}
	
	public double getPriceAvg() {
		int totalPrice = 0;
		for(int i = 0; i< size; i++) {
			totalPrice += books[i].getPrice();
		}
		
		return (totalPrice / size); // 모든 book의 가격을 size(book 의 개수)로 나눔
	}
	
	
}
