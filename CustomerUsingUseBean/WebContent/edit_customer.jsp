<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form id="form-1" action="EditController" method="post">
	
		<label>Id</label>
		<input name="id" value=<%=request.getParameter("id")%>  type="text"/><br/>
		
		<label>Name</label>
		<input name="name" value=<%=request.getParameter("name") %> type="text"/><br/>
		
		<label>Address</label>
		<input name="address" value=<%=request.getParameter("address") %> type="text"/><br/>
		
		<label>Item</label>
		<input name="item" value=<%=request.getParameter("item") %> type="text"/><br/>
		
		<input type="submit" value="Update">
		
	</form>

</body>
</html>