<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style type="text/css">

.list {
     display: flex;
     justify-content: space-around;
     align-items: center;
}

.btn {
    height: 40px;
}
</style>
</head>
<body>

<div class="list">
<h1 class="display-2">Book List.</h1> 
<a href="add" class="btn btn-secondary" class="add">Add Book</a>
<a href="restore" class="btn btn-secondary" class="add">Restore Book</a>
  </div>

	<hr>

		<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col">NO</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      
      <th scope="col">Quantity</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${books}" varStatus="count">
    <tr>
    <td>${count.count} </td>
			<td> ${book.name} </td>
			<td> ${book.price} </td>
			<td> ${book.quantity} </td>
			<td> <a href="edit/${book.id}" class="btn btn-primary">Edit</a></td>
			<td> <a href="delete/${book.id}" class="btn btn-danger">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</body>
</html>