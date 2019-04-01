<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
				<h2>Subject Details</h2>
				<table border="2" class="table-sm table-striped table-bordered table-hover">
				<tbody>
				<tr>
					<td>Subject ID</td>
					<td>Subject Title</td>
					<td>Hours</td>
					<td>Book ID</td>
				</tr>
				<c:forEach items="${subjects}" var="subject"> 
				  <tr>
				    <td>${subject.subject_id}</td>
				    <td>${subject.subtitle}</td>
				    <td>${subject.duration_in_hours}</td>
				    <td>${subject.book_id}</td>
				  </tr>
				</c:forEach>
				</tbody>
				</table>
</body>
</html>