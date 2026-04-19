package servlet;

import javax.servlet.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import model.Book;
import service.LibraryService;
import service.LibraryServiceImpl;

@WebServlet("/displayBooks")
public class DisplayBooksServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LibraryService service = new LibraryServiceImpl();
		List<Book> list = service.getAllBooks();
		req.setAttribute("books", list);
		RequestDispatcher rd = req.getRequestDispatcher("displayBooks.jsp");
		rd.forward(req, res);
	}
}
