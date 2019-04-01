<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<h2>Book Details</h2>
				<table border="2" class="table-sm table-striped table-bordered table-hover">
				<tbody>
				<tr>
					<td>Book ID</td>
					<td>Book Title</td>
					<td>Book Price</td>
					<td>Book Volume</td>
					<td>Book Published Date</td>
				</tr>
				<c:forEach items="${books}" var="book"> 
				  <tr>
				    <td>${book.book_id}</td>
				    <td>${book.title}</td>
				    <td>${book.price}</td>
				    <td>${book.volume}</td>
				    <td>${book.publishedDate}</td>
				  </tr>
				</c:forEach>
				</tbody>
				</table>
</body>
</html>