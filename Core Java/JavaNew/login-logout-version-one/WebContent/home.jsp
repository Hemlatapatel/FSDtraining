<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%!
List <String> list = null;
%>

<%
	try {
		Context ctx = new InitialContext();
		 list = new ArrayList<String>();

		DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/ibm");
		Connection con = ds.getConnection();
		Statement st =   con.createStatement();
		ResultSet rs = st.executeQuery("select userType from userDetail");
		
		while(rs.next()) {
			list.add(rs.getString(1));
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
</head>
<body>

	<form id="form-1" action="LoginController" method="post">
	
		<label for="uName">User Name:</label>
		<input id="uNameId" name="uName" placeholder="User Name" autofocus="true" required="true" type="text"/><br/>
	
		<label for="passwordId">Password:</label>
		<input id="passwordId" name="password" placeholder="Password" autofocus="true" required="true" type="password"/><br/>
	
	<select name="userType">
	<option value="UNKNOWN">select...</option>
	<%
	   for(String str: list) {
		   %>
		   <option value=<%=str %>><%=str %></option>
		   
	 <%  }
	%>
	</select><br/>
	
	<input type="submit" value="Login" id="button-1"/>
	</form>

</body>
</html>