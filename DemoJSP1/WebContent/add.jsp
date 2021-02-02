<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Calculator</h1>
	
	
	<form method="post" action="add">
		<input name="num1" 
		<%if(request.getAttribute("num1")!=null){
			out.println("value=\"" + request.getAttribute("num1") + "\"");
		} %>
		> + 
		
		<input name="num2" 
		<%if(request.getAttribute("num2")!=null){ %>
		value="<%=request.getAttribute("num2") %>"
		<%} %>
		> =
		
		<input name="res" disabled
		<%if(request.getAttribute("res")!=null){ %>
		value="<%=request.getAttribute("res") %>"
		<%} %>
		><br><br>
		<input type="submit" value="add" >
	</form>
</body>
</html>