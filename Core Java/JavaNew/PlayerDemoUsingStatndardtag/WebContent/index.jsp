<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="pBean" scope="request" class="com.example.model.Player">
<jsp:setProperty name="pBean" property="*" />  
<jsp:getProperty name="pBean" property="playerName" />  
<jsp:getProperty name="pBean" property="teamName" />  
<jsp:getProperty name="pBean" property="playerCountry" />  

</jsp:useBean>  

</body>
</html>