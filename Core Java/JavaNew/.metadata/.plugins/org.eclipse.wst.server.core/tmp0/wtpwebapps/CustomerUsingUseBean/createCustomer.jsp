<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
</head>
<body>
<h2>New Customer</h2>

<%
		List<String> l = (List<String>) request.getAttribute("ERROR");
		if (l != null) {
			
			for(String str:l)
			{%>
	<font color='red'><%=str%></font>
	<br />
	<% }%>

	<% }%>
	
<form id="form-1" action="CustomerController" method="post">
	<label>Name:</label>
	<input id="nameId" name="name" placeholder="Text" type="text"/><br/>
	
	<label>Address:</label>
	<input id="addressId" name="address" placeholder="Text" type="text"/><br/>
	
	<label>Item:</label>
	<select name="item">
	<option value="UNKNOWN">select</option>
	<option value="Laptop">Laptop</option>
	<option value="Mobile">Mobile</option>
	<option value="Desktop">Desktop</option>
	</select><br>
	<input type="submit" value="submit">
	
</form>
<%--<jsp:include page="WEB-INF/list_customer.jsp" />   --%>

<a href="list_customer.jsp">Customer List</a>
</body>
</html>