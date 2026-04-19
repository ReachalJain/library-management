package service;

import java.util.List;
import dao.BookDAO;
import dao.IssueBookDAO;
import dao.impl.BookDAOImpl;
import dao.impl.IssueBookDAOImpl;
import model.Book;
import model.IssuedBook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;

public class LibraryServiceImpl implements LibraryService {
	private static final String url = "jdbc:mysql://localhost:3306/library_data";
	private static final String user = "root";
	private static final String password = "Reachal";

	private BookDAO bookDAO = new BookDAOImpl();
	private IssueBookDAO issueBookDAO = new IssueBookDAOImpl();

	@Override
	public void addBook(Book book) {
		System.out.println("SERVICE ADD CALLED");
		bookDAO.addBook(book);
	}

	@Override
	public void removeBook(int bookNo) {
		bookDAO.removeBook(bookNo);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}

	@Override
	public void issueBook(int bookNo, int issueQty) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			// c.setAutoCommit(false);
			int availableQty = bookDAO.getAvailableQuantity(bookNo);
			if (availableQty >= issueQty) {
				int newQty = availableQty - issueQty;
				bookDAO.updateQuantity(bookNo, newQty);
				IssuedBook issuedBook = new IssuedBook();
				issuedBook.setBookNo(bookNo);
				issuedBook.setIssueQty(issueQty);
				issuedBook.setIssueDate(new Date(System.currentTimeMillis()));
				issueBookDAO.addIssuedBook(issuedBook);
				// c.commit();
				System.out.println("Book issued Successsfully!!!!!!!!!!");

			} else {
				System.out.println("Not enough quantity available");
				// c.rollback();
			}

		} catch (Exception e) {
			try {
				if (c != null) {
					c.rollback();

				}
			} catch (Exception ex) {
				ex.printStackTrace();

			}
			e.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
