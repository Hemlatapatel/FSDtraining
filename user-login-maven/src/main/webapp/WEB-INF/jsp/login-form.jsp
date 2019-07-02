<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="c:url value=" /resources/css/main.css" rel="stylesheet">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login form</h2>
	<form:form action="checkUser" method="post" modelAttribute="user">
UserName: <form:input path="userName" />
		<br />
		<form:errors path="userName" />
		<br />
Password: <form:input type="password" path="password" />
		<br />
		<form:errors path="password" />
		<br />

${error}
		<input type="submit" value="submit">
	</form:form>

</body>
</html>