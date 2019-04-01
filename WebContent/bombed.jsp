<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="4;url=destroy.html">
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
	<h2 align = "center">Give us a perfect score</h2>
	<h3 align = "center">Exposing all your database records</h3>
	<h4 align = "center">Deleting all your database records in T-minus 3 seconds</h4>
	<hr width = "70%">

	<table align = "center" width = "40%">
		
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
				<td align = "center"><%= rs.getString("ID") %></td>
				<td align = "center"><%= rs.getString("SEARCH") %>
				<td align = "center"><%= rs.getString("DATE") %></td>
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