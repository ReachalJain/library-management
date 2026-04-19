package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import model.Book;
import service.LibraryService;
import service.LibraryServiceImpl;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("BOOK NO. =" + req.getParameter("bookNo"));

		int bookNo = Integer.parseInt(req.getParameter("bookNo").trim());

		String bookName = req.getParameter("bookName").trim();
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		Book book = new Book(bookNo, bookName, price, quantity);
		LibraryService service = new LibraryServiceImpl();
		service.addBook(book);
		req.setAttribute("msg", "Book addedsuccessfully");
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		rd.forward(req, res);

	}

}
