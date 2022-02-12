<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>CSD3354</th>
				<th>CSD4464</th>
				<th>CSD4203</th>
				<th>CSD3183</th>
				<th>CSD3313</th>
				<th>Phone Number</th>
			</tr>
		</thead>
		<tbody>
			<%
			session = request.getSession(false);
			List<String[]> studentData = (List<String[]>) session.getAttribute("student-data");
			for (int i = 0; i < studentData.size(); i++) {
			%>
			<tr>
				<%
				for (int j = 0; j < studentData.get(i).length; j++) {
				%>
				<td><%=studentData.get(i)[j]%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>