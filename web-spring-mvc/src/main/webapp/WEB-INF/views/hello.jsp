<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello</h1>
	<form action="hello" method="post">
	Id:<input type="text" name="id"><br>
	<input type="submit" name="submit" value="submit">
	<h1>The id is ${deb}</h1>
	</form>
</body>
</html>