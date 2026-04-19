package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import service.LibraryService;
import service.LibraryServiceImpl;

@WebServlet("/removeBook")
public class RemoveBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		LibraryService service = new LibraryServiceImpl();
		service.removeBook(bookNo);
		req.setAttribute("msg", "Book removed  successfully!!!!!!!!!!!!");
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		rd.forward(req, res);

	}

}
