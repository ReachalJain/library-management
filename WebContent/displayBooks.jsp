<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Book"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>

	<h2>All Books</h2>

	<table border="1">
		<tr>
			<th>Book No</th>
			<th>Book Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>

		<%
			List<Book> list = (List<Book>) request.getAttribute("books");

		if (list != null) {
			for (Book book : list) {
		%>
		<tr>
			<td><%=book.getBookNo()%></td>
			<td><%=book.getBookName()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getQuantity()%></td>
		</tr>
		<%
			}
		}
		%>

	</table>

</body>
</html>