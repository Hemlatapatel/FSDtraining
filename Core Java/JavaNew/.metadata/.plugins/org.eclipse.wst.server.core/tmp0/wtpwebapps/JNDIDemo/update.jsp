<%@ page import="comm.example.model.Employee" %>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="UpdateController" method="post">
		<h2>Update Employee data</h2>
		<table id="table-1">
			<tbody>
				<tr>
					<td><label id="label-1">Enter id:</label></td>
					<td><label for="searchId"></label> <input id="searchId"
						placeholder="Enter Id here" type="text" name="emp_id" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search" id="update" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<form>

		<%
			List<Employee> empList = (List<Employee>) request.getAttribute("Employee");
			if (empList != null) {
				for (Employee emp : empList) {
					%>
					<%=emp.getFirstName() %>
					<%=emp.getLastName() %>
					<%=emp.getSalary()%>
			   <% 
				}
			}
		%>
	</form>
	
</body>
</html>