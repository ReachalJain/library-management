package model;

public class Book {
	private int bookNo;
	private String bookName;
	private double price;
	private int quantity;

	public Book() {

	}

	public Book(int bookNo, String bookName, double price, int quantity) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.price = price;
		this.quantity = quantity;

	}

	public int getBookNo() {
		return bookNo;

	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;

	}

	public String getBookName() {
		return bookName;

	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getPrice() {
		return price;

	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
