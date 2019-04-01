<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
		<div class="container">
	 <div class="row">
	 		<div class="col-4">
	 		<form:form id="subjectForm" modelAttribute="subject">	 		
	 			<h2>Subject Form</h2>
	 			<table class="table-sm table-striped table-hover">
	 				<tbody>
		 					<tr>
		 						<td style="width: 65%"><label>Subject ID</label></td>
		 						<td><form:input type="text" id="subject_id" path="subject_id" placeholder="enter subject id"/></td>
		 					</tr>
							<tr>
								<td style="width: 65%"><label>Subject Title</label></td>
								<td><form:input type="text" path="subtitle" placeholder="enter title"/></td>
							</tr>
							<tr>
								<td style="width: 65%"><label>Duration in Hours</label></td>
								<td><form:input type="text" id="duration" path="duration_in_hours" placeholder="enter dureation in hrs"/></td>
							</tr>
<!-- 							<tr> -->
<!-- 								<td style="width: 65%"><label>Book ID</label></td> -->
<%-- 								<td><form:input type="text" path="book_id" placeholder="enter dureation in hrs"/></td> --%>
<!-- 							</tr>							 -->
							<tr>
								<td style="width: 65%"><label>Book ID</label></td>
								<td>
									<form:select path="book_id" items="${books}" />
<!-- 									<select id="books" path="book_id"> -->
<%-- 									<c:forEach items="${books}" var="book"> --%>
<%-- 										<option value="${book.book_id}">${book.book_id}</option> --%>
<%-- 									</c:forEach> --%>
<!-- 									</select>								 -->
								</td>
							</tr>
 			
	 				</tbody>
	 			</table>
				<button type="button" class="btn btn-primary" onClick="addSubject(event);">Add Subject</button>
				<button type="button" class="btn btn-primary" onClick="searchSubject(event);">Search</button>
				<button type="button" class="btn btn-primary" onClick="deleteSubject(event);">Delete</button>		 			
	 			</form:form>
	 		</div>
			<div id="showSubjects" class="col-8">
				<%@include file="showSubjects.jsp" %>
			</div>
		</div>
	</div> 
</body>
</html>