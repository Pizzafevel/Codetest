<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	height: 500px;
	padding: 20px;
	border-radius: 20px;
	background-color: white;
}
 </style>
</head>
<body>


   <div class = "contain">
		<form:form modelAttribute="regobj" action= "adduser" method = "post" class="form">
		
		<h1>Register</h1>
		
		Name <form:input path="name" class="form-control" type="text" required="required"/> <br>
		Email <form:input path="email" class="form-control" type="email" required="required"/> <br>
	    Password <form:input path="password" class="form-control" type="password" required="required"/> <br>
	    
	    <input type= "submit" value= "submit" type="button" class="btn btn-primary">
	    
	    
	    <a href="login">Login</a>
		</form:form>
		
		</div>
</body>
</html>