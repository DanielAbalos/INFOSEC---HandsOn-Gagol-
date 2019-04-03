package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/destroy.html")
public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infosec_handson","root","");
			PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement("DROP TABLE searchqueries");
			pstmt.executeUpdate();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("SQLException - bombed.jsp");
		
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			System.out.println("ClassNotFoundException - bombed.jsp");
		}
		
		response.sendRedirect("haha.html");
	}

}
