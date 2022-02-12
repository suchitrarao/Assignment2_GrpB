<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>
			The area of triangle with base
			<%=session.getAttribute("base")%>
			and height
			<%=session.getAttribute("height")%>
			is equal to
			<%=session.getAttribute("triangle-area")%></p>
		<br>
		<p>
			The area of square with side
			<%=session.getAttribute("side")%>
			is equal to
			<%=session.getAttribute("square-area")%></p>
	</div>
</body>
</html>