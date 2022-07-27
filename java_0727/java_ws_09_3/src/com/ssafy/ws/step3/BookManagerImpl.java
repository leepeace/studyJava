package com.ssafy.ws.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//IBookManager인터페이스를 구현한 클래스
public class BookManagerImpl implements IBookManager {
	
	//private static int MAX_SIZE = 100;
	private List<Book> books = new ArrayList<>();
	//private int size = 0;
	
	//싱글톤 패턴 적용
	private static IBookManager instance = new BookManagerImpl();
	
	private BookManagerImpl() {
		
	}
	
	public static IBookManager getInstance() {
		return instance;
	}

	//추가,삭제,조회 기능 구현
	
	@Override
	public void add(Book book) {
		books.add(book);
	}
	
	@Override
	public void remove(String isbn) {
		for(int i = 0; i <= books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				System.out.println("****************도서삭제 :" + isbn + "****************");
				for(int j = i+1; j <= books.size(); j++) {
					books.remove(i);
					i--;
				}
				//books[size--] = null;
				break;
			}
		}
	}
	
	@Override
	public Book[] getList() {
		//return Arrays.copyOfRange(books, 0, books.size());
		
		return books.toArray(new Book[books.size()]);
	}
	
	@Override
	public Book searchByIsbn(String isbn) {
		for(int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)){
				return books.get(i);
			
			}
		}
		return null;
	}
	
	//책의 제목 중 일부가 일치하는 책의 수를 카운트
	@Override
	public Book[] searchByTitle(String title){ 
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book book : books) {
			if(book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		
		return temp.toArray(new Book[temp.size()]);
	}
	
	@Override
	public Book[] getBooks() {
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book book : books) {
			if(book instanceof Book) {
				temp.add(book);
			}
		}

		return temp.toArray(new Book[temp.size()]);
	}
	
	@Override
	public Magazine[] getMagazines() { 
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book book : books) {
			if(book instanceof Magazine) {
				temp.add(book);
			}
		}

		return temp.toArray(new Magazine[temp.size()]);
	}
	
	@Override
	public int getTotalPrice() {
		int totalPrice = 0;
		for(int i = 0; i< books.size(); i++) {
			totalPrice += books.get(i).getPrice(); // 모든 book의 가격을 더함
		}
		return totalPrice;
	}
	
	@Override
	public double getPriceAvg() {
		int totalPrice = 0;
		for(int i = 0; i< books.size(); i++) {
			totalPrice += books.get(i).getPrice();
		}
		
		return (totalPrice / books.size()); // 모든 book의 가격을 size(book 의 개수)로 나눔
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		//고유번호에 해당하는 도서를 원하는 수량만큼 판매함
	
		Book book = searchByIsbn(isbn);
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		int result = book.getQuantity() - quantity;
		if(result < 0) {
			throw new QuantityException();
		}
		book.setQuantity(result);
		/*		boolean check = false;
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				check = true;
				if((books.get(i).getQuantity() - quantity) >= 0) {
					books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
					break;
				}else {
					throw new QuantityException();
				}
						
			}else {
				check = false;
			}
		}
		
		if(!check) {
			throw new ISBNNotFoundException(isbn);
		}*/
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		//고유번호에 해당하는 도서를 원하는 수량만큼 구매함
		Book book = searchByIsbn(isbn);
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		book.setQuantity(book.getQuantity() + quantity);
/*		boolean check = false;
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				check = true;
				break;
			}else {
				check = false;
			}
		}
		
		if(!check) {
			throw new ISBNNotFoundException();
		}*/
		
	}
	
	

}
