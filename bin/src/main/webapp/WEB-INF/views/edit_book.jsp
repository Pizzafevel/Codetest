<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

 <style type="text/css">
 
 body {
 	background-color: black;
 }
 .error {
 color: red;
 }
 a{
   padding-left: 20px;
   text-decoration: none;
   color: black;
 }
 .contain {
 display: flex;
 align-items: center;
 justify-content: center;
 height: 650px;
 border: 1px solid black;
 }
 .form{
	width: 400px;
	height: 400px;
	padding: 20px;
	border-radius: 20px;
	background-color: white;
}
 </style>
</head>
<body>
<div class = "contain">
	<form:form action="${pageContext.request.contextPath}/edit" method="POST" modelAttribute="book" class="form">
	<h2>Edit Book</h2>
	 <input type="hidden" name="id" value="${book.id}" />
		<label> Book Name:  </label>
		<form:input path="name" type="text" class="form-control" placeholder="Enter your book name....."></form:input>
		<br>
			<label> Book Price:  </label>
		<form:input type="number" path="price" class="form-control" placeholder="Enter your book price....."></form:input>
		<br>
			<label> Book Quantity:  </label>
		<form:input type="number" path="quantity" class="form-control" placeholder="Enter your book price....."></form:input>
		<br>
		<input type="submit" class="btn btn-primary" value="Update Book">
		
	</form:form>
	</div>
</body>
</html>