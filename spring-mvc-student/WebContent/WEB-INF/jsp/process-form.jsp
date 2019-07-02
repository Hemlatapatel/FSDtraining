<%@page import="com.example.springdemo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello ${student.firstName } ${student.lastName }
<br/>
Country: ${student.country}
<br/>
Favorite Language: ${ student.favoriteLanguage}
<%--

Student s = (Student)request.getAttribute("student");

String[] arr = s.getLanguage();
for(String s1:arr) {
	out.println(s1 + ", ");
}
--%>
<br/>

Operating system: 
<%
Student s = (Student)request.getAttribute("student");

String str[] = s.getOperatingSystem();
for(String s2: str) {
	out.println(s2+ ",");
}
%>
<br/>
<a href="../home">Home page</a>
</body>
</html>