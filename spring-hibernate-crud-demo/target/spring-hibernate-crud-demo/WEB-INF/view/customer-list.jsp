<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Customers List</h2>

<table border="1" >
<tr>
<td>Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Email</td>
<td colspan="2">Operation</td>

</tr>

<c:forEach var="customer" items="${customerList }">
<tr>
<td>${customer.id }</td>
<td>${customer.firstName}</td>
<td>${customer.lastName}</td>
<td>${customer.email}</td>
 
<td><a href="/spring-hibernate-crud-demo/customer/update/${customer.id }">Update</a></td>

<td><a href="/spring-hibernate-crud-demo/customer/delete/${customer.id }">Delete</a></td>

</tr>
</c:forEach>

</table>
</body>
</html>