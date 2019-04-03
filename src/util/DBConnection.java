package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class DBConnection {
	
	public boolean storeToDB(String class4Name, String url, String username, String password, String search, String date){
		
		try{
			Class.forName(class4Name);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO searchqueries "
					+ "(SEARCH, DATE)"
					+ "VALUES (?,?)");
			
			pstmt.setString(1, search);
			pstmt.setString(2, date);
			
			pstmt.execute();
			
			conn.close();
			
			return true;
			
		}catch(MySQLSyntaxErrorException msqlslqe){	
			msqlslqe.printStackTrace();
			return false;
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("SQLException - DBConnection");
			return false;
		
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("ClassNotFoundException - DBConnection");
			return false;
		}
	}
	
	public void dropDB(String class4Name, String url, String username, String password){
		try{
			Class.forName(class4Name);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement("DROP TABLE searchqueries");
			pstmt.executeUpdate();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("SQLException - bombed.jsp");
		
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("ClassNotFoundException - bombed.jsp");
		}
	}

}
