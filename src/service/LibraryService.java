package service;

import java.util.List;
import model.Book;

public interface LibraryService {
	void addBook(Book book);

	void removeBook(int bookNo);

	void issueBook(int bookNo, int issueQty);

	List<Book> getAllBooks();

}
