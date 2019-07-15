<html>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<head>
<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>

	Welcome to the luv2code company home page!
	<br>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="post">

		User:
		<security:authentication property="principal.username" />

		Role:
		<security:authentication property="principal.authorities" />
			
			Click on leaders button for manager meeting
			<a href="${pageContext.request.contextPath}/leaders"
			class="btn btn-primary">Leaders</a>
		<br>
			
			Click on systems button for admin meeting
			
			 <a href="${pageContext.request.contextPath}/systems"
			class="btn btn-primary">System</a>

		<br />
		<input type="submit" value=Logout>

	</form:form>
</body>
</html>
