package com.ssafy.ws.step3;

/**
 * 잡지 정보를 나타내는 클래스
 */
public class Magazine extends Book {

	private int year;
    private int month;

    public Magazine(){
        super();
    }
    public Magazine(String isbn, String title, String author,
                        String publisher,int price, String desc, int year, int month, int quantity){
        super(isbn,title,author,publisher,price,desc, quantity);
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String toString(){
        return  this.getIsbn() + "   |   " +
                this.getTitle() + '\t' + "   |   " + this.getAuthor() + '\t' + "   |   " + this.getPublisher() +  "   |   "
                + String.valueOf(this.getPrice()) + "   |   " + this.getDesc() + "   |   " + year + "   |   "
                + month;
    }
}
