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
			String[] firstnameList = (String[]) session.getAttribute("firstname");
			String[] lastnameList = (String[]) session.getAttribute("lastname");
			String[] addressList = (String[]) session.getAttribute("address");
			String[] subject1List = (String[]) session.getAttribute("subject1");
			String[] subject2List = (String[]) session.getAttribute("subject2");
			String[] subject3List = (String[]) session.getAttribute("subject3");
			String[] subject4List = (String[]) session.getAttribute("subject4");
			String[] subject5List = (String[]) session.getAttribute("subject5");
			String[] phonenumber = (String[]) session.getAttribute("phonenumber");

			for (int i = 0; i < firstnameList.length; i++) {
			%>
			<tr>
				<td><%=firstnameList[i]%></td>
				<td><%=lastnameList[i]%></td>
				<td><%=addressList[i]%></td>
				<td><%=subject1List[i]%></td>
				<td><%=subject2List[i]%></td>
				<td><%=subject3List[i]%></td>
				<td><%=subject4List[i]%></td>
				<td><%=subject5List[i]%></td>
				<td><%=phonenumber[i]%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>