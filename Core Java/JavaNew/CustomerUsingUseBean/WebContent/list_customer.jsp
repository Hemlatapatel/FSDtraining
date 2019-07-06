<%@ page import="java.util.*"%>
<%@ page import="com.example.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer list</h2>
	<form id="form-1" action="GetAllCustomer" method="post">
		<input type="submit" value="List All Customer">
	</form>

	<%
		List<Customer> custList = (List<Customer>) request.getAttribute("custList");
		if (custList != null) {
	%>

	<table id="table-1" border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Item</th>
			
				<th colspan=2>Action</th>
			</tr>
		</thead>

		<%
			for (Customer c : custList) {
		%>
		<tr>
		    <td><%=c.getId() %></td>
			<td><%=c.getName()%></td>
			<td><%=c.getAddress()%></td>
			<td><%=c.getItem()%></td> 			 
			<td><a href="edit_customer.jsp?id=<%=c.getId()%>&name=<%=c.getName()%>&address=<%=c.getAddress()%>&item=<%=c.getItem()%>">Edit</a></td>
			<td><a href="DeleteController?id=<%=c.getId() %>">Delete</a></td>
		</tr>

		<%
			}
		%>
	</table>

	<%
		}
	%>

</body>
</html>