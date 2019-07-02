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
<h2>Students List</h2>

<table border="1" >
<tr>
<td>Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Country</td>
<td>Favorite language</td>
<td>Operating system</td>
<td colspan="2">Operations</td>

</tr>
<tr>
<c:forEach var="std" items="${studentList }">
<td>${std.id }</td>
<td>${std.firstName}</td>
<td>${std.lastName}</td>
<td>${std.country}</td>
<td>${std.favoriteLanguage}</td>
<td>${std.operating}</td>
<td><a href="/spring-mvc-student/student/edit/${std.id }">Edit</a></td>

<td><a href="/spring-mvc-student/student/delete/${std.id }">Delete</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>