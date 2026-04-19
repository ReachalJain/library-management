package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import service.LibraryService;
import service.LibraryServiceImpl;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(">>> ISSUE BOOK SERVLET HIT <<<");

		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		int issueQty = Integer.parseInt(req.getParameter("issueQty"));
		LibraryService service = new LibraryServiceImpl();
		service.issueBook(bookNo, issueQty);
		req.setAttribute("msg", "Book issue process completed!!!!!!!!!!!!");
		RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
		rd.forward(req, res);

	}

}
