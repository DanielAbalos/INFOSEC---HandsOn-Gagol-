<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="3;url=destroy.html">
<title>Bombed</title>
</head>
<body>

	<%@ page import = "java.text.SimpleDateFormat,
		java.util.Date,
		java.sql.Connection,
		java.sql.DriverManager,
		java.sql.ResultSet,
		java.sql.SQLException,
		java.sql.Statement"
	%>
	
	<h1 align = "center">You've Been Hacked</h1>
	<h3 align = "center">Deleting all your database records in T-minus 3 seconds</h3>
	<hr width = "70%">

	<table align = "center">
		
		<tr>
			<th>ID</th>
			<th>SEARCH</th>
			<th>DATE</th>
		</tr>
		
		<%
	
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosec_handson","root","");
					PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement("SELECT * FROM `searchqueries`");
					ResultSet rs = pstmt.executeQuery();
			
					while(rs.next()){
			%>
			
			<tr>
				<td><%= rs.getString("ID") %></td>
				<td><%= rs.getString("SEARCH") %>
				<td><%= rs.getString("DATE") %></td>
			</tr>
			
			<%
					}
			
				}catch(SQLException sqle){
					System.out.println("SQLException in home.jsp");
					sqle.printStackTrace();
			
				}
	
			%>
	
	</table>

</body>
</html>