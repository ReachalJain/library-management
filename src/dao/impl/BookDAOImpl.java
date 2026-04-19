package dao.impl;

import dao.BookDAO;
import java.util.ArrayList;
import java.util.List;
import model.Book;

import java.sql.*;

public class BookDAOImpl implements BookDAO {
	private static final String url = "jdbc:mysql://localhost:3306/library_data";
	private static final String user = "root";
	private static final String password = "Reachal";

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		String sql = "select * from books";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBookNo(rs.getInt("book_no"));
				b.setBookName(rs.getString("book_name"));
				b.setPrice(rs.getDouble("price"));
				b.setQuantity(rs.getInt("quantity"));
				list.add(b);
			}
			rs.close();
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addBook(Book book) {

		String sql = "insert into books(book_no,book_name,price,quantity) values (?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, book.getBookNo());
			p.setString(2, book.getBookName());
			p.setDouble(3, book.getPrice());
			p.setInt(4, book.getQuantity());
			p.executeUpdate();
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBook(int bookNo) {
		String sql = "delete from books where book_no=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, bookNo);

			p.executeUpdate();
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getAvailableQuantity(int bookNo) {
		String sql = "select quantity from books where book_no=?";
		int qty = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, bookNo);
			ResultSet r = p.executeQuery();
			if (r.next()) {
				qty = r.getInt("quantity");
			}
			r.close();
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}

	@Override
	public void updateQuantity(int bookNo, int quantity) {
		String sql = "update books set quantity=? where book_no=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, quantity);
			p.setInt(2, bookNo);
			p.executeUpdate();
			p.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
