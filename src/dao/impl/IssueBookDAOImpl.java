package dao.impl;

import model.IssuedBook;
import dao.IssueBookDAO;
import java.sql.*;

public class IssueBookDAOImpl implements IssueBookDAO {
	private static final String url = "jdbc:mysql://localhost:3306/library_data";
	private static final String user = "root";
	private static final String password = "Reachal";

	@Override
	public void addIssuedBook(IssuedBook issuedBook) {
		String sql = "insert into issued_books(book_no,issue_qty,issue_date) values (?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, issuedBook.getBookNo());
			p.setInt(2, issuedBook.getIssueQty());
			p.setDate(3, issuedBook.getIssueDate());
			int rows = p.executeUpdate();
			System.out.println("ISSUED BOOK ROWS = " + rows);
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
