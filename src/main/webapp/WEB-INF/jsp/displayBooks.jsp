<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->

<body>
<!-- 	<div class="container"> -->
	 <div class="row">
	 		<div class="col-4">
	 		<form:form id="bookForm" modelAttribute="book">	 		
	 			<h2>Book Form</h2>
	 			<table class="table-sm table-striped table-hover">
	 				<tbody>
		 					<tr>
		 						<td style="width: 65%"><label>Book ID</label></td>
		 						<td><form:input type="text" id="bookId" path="book_id" placeholder="enter book id"/></td>
		 					</tr>
							<tr>
								<td style="width: 65%"><label>Book Title</label></td>
								<td><form:input type="text" id="bookTitle" path="title" placeholder="enter title"/></td>
							</tr>
							<tr>
								<td style="width: 65%"><label>Book Price</label></td>
								<td><form:input type="text" path="price" placeholder="enter price"/></td>
							</tr>
							<tr>
								<td style="width: 65%"><label>Book Volume</label></td>
								<td><form:input type="text" path="volume" placeholder="enter volume"/></td>
							</tr>
							<tr>
								<td style="width: 65%"><label>Book Published Date</label></td>
								<td><form:input type="date" path="publishedDate" /></td>
							</tr>
<!-- 							<tr><div id="saveInfo"></div></tr> -->
 			
	 				</tbody>
	 			</table>
				<button type="button" class="btn btn-primary" onClick="addBook(event);">Add Book</button>
				<button type="button" class="btn btn-primary" onClick="searchBook(event);">Search</button>
				<button type="button" class="btn btn-primary" onClick="deleteBook(event);">Delete</button>		 			
	 			</form:form>
	 		</div>
			<div id="showBooks" class="col-8">
				<%@include file="showBooks.jsp" %>
			</div>
		</div>
<!-- 	</div>  -->
	
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> -->
	
</body>	
</html>