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
	<% if(request.getParameter("num1") != null && request.getParameter("num2") != null){
	 	int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int result = number1 + number2;
		request.setAttribute("num1", number1);
		request.setAttribute("num2", number2);
		request.setAttribute("res", result);
	}
//	else{
//		request.setAttribute("num1", 0);
//		request.setAttribute("num2", 0);
//		request.setAttribute("res", 0);
//	}
	%>
	
	<form method="post">
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