<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="4;url=destroy.html">
<title>Bombed</title>
</head>
<body bgcolor="black">

	<%@ page import = "java.text.SimpleDateFormat,
		java.util.Date,
		java.sql.Connection,
		java.sql.DriverManager,
		java.sql.ResultSet,
		java.sql.SQLException,
		java.sql.Statement"
	%>
	<center>
	<h1 style= "color:limegreen;">You've Been Hacked</h1>
	<h2 style= "color:limegreen;">Give us a perfect score</h2>
	<h3 style= "color:limegreen;">Exposing all your database records</h3>
	<h4 style= "color:limegreen;">Deleting all your database records in T-minus 3 seconds</h4>
	<hr width = "70%">
	</center>
	<table align = "center" width = "40%">
		
		<tr>
			<th><font color="limegreen">ID</font></th>
			<th><font color="limegreen">SEARCH</font></th>
			<th><font color="limegreen">DATE</font></th>
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
			<center>
				<td ><font color="limegreen"><%= rs.getString("ID") %></font></td>
				<td ><font color="limegreen"><%= rs.getString("SEARCH")%></font></td>
				<td ><font color="limegreen"><%= rs.getString("DATE") %></font></td>
			</center>
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