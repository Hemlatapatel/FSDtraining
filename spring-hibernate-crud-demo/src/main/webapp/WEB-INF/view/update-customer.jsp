<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management System</title>
</head>
<body>
<h2>Customer form</h2>
<form:form action="updatedCustomer" method="post" modelAttribute="customer">
First Name: <form:input path="firstName" value="${customer.firstName}"/><br/>
Last Name: <form:input path="lastName" value="${customer.lastName}"/><br/>

Email: <form:input path="email" value="${customer.email}"/><br/>


<input type="submit" value="update">
</form:form>

</body>
</html>