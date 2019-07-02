<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <link href="c:url value="/resources/css/main.css" rel="stylesheet">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student form</h2>
<form:form action="../editedForm" method="post" modelAttribute="student">

Id:<form:input path="id" value="${id }"/><br/>
First Name: <form:input path="firstName"/><br/>
<form:errors path="firstName"/><br/>
Last Name: <form:input path="lastName"/><br/>
<form:errors path="lastName"/><br/>

Country<form:select path="country">
<form:options items="${student.countries }"></form:options>
</form:select><br/>
<form:errors path="country"/><br/>


Favorite Language <br/>
Java<form:radiobutton path="favoriteLanguage" value="java"/>
Ruby<form:radiobutton path="favoriteLanguage" value="ruby"/>
Blockchain<form:radiobutton path="favoriteLanguage" value="blockchain"/>
Python<form:radiobutton path="favoriteLanguage" value="python"/>

<form:errors path="favoriteLanguage"/><br/>

<br/><br/>

Operating System<br/>
<form:checkboxes path="operatingSystem" items="${student.operatingSystem }"/>
<br/>
<input type="submit" value="submit">
</form:form>

</body>
</html>