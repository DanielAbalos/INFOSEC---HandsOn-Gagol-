package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DBConnection {
	
	public void storeToDB(String search, String date){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosec_handson","root","");
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO searchqueries "
					+ "(SEARCH, DATE)"
					+ "VALUES (?,?)");
			
			pstmt.setString(1, search);
			pstmt.setString(2, date);
			
			pstmt.execute();
			
			conn.close();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("SQLException - DBConnection");
		
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("ClassNotFoundException - DBConnection");
		}
	}

}
