<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
.containn {
   width: 100%;
   height: 600px;
   display: flex;
   justify-content: center;
   align-items: center;
}
.contain {
    width: 400px;
    height: 250px;
    border: 1px solid black;
    text-align: center;
    background-color: white;
    padding: 20px;
    border-radius: 20px;
}

</style>
</head>
<body>  
   <div class="containn">   
   <div class="contain">
   <h1>Login Successful!</h1>
   <br>
   <br>
   <br>
          <a href="getbookall"> <button type="button" class="btn btn-success">Show Books</button></a>  
          </div>
          </div>
</body>
</html>