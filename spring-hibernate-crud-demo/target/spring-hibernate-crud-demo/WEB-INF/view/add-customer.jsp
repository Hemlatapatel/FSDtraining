<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management System</title>
</head>
<body>
<h2>Customer form</h2>
<form:form action="processForm" method="post" modelAttribute="customer">
First Name: <form:input path="firstName"/><br/>
Last Name: <form:input path="lastName"/><br/>

Email: <form:input path="email"/><br/>

<input type="submit" value="add customer">
</form:form>

</body>
</html>