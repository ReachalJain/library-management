package dao;

import java.util.List;

import model.Book;

public interface BookDAO {
	void addBook(Book book);

	List<Book> getAllBooks();

	void removeBook(int bookNo);

	int getAvailableQuantity(int bookNo);

	void updateQuantity(int bookNo, int quantity);

}
