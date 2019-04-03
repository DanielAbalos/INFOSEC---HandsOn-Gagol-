package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnection;
import model.SearchModel;

@WebServlet("/bomb.html")
public class TheBombServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String classDotForName = getServletContext().getInitParameter("classDotForName");
		String jdbcUrl = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		SearchModel sm = new SearchModel();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		sm.setSearch(request.getParameter("searchField"));
		sm.setDate(format.format(date).toString());
		
		System.out.println(sm.getSearch());
		System.out.println(sm.getDate());
		
		DBConnection dbc = new DBConnection();
		
		if(sm.getSearch().isEmpty()){
			response.sendRedirect("index.html");	
		
		}else if(!sm.getSearch().equalsIgnoreCase("initiate green poison attack")){
			if(dbc.storeToDB(classDotForName, jdbcUrl, jdbcUsername, jdbcPassword, sm.getSearch(), sm.getDate()))
				response.sendRedirect("https://www.google.com/search?q=" + sm.getSearch());
			else
				response.sendRedirect("down.html");

		}else{
			if(dbc.storeToDB(classDotForName, jdbcUrl, jdbcUsername, jdbcPassword, sm.getSearch(), sm.getDate()))
				response.sendRedirect("hacking.html");
			else
				response.sendRedirect("down.html");
		}
	}

}