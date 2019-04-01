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
		
		SearchModel sm = new SearchModel();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		sm.setSearch(request.getParameter("searchField"));
		sm.setDate(format.format(date).toString());
		
		System.out.println(sm.getSearch());
		System.out.println(sm.getDate());
		
		
		if(!sm.getSearch().equalsIgnoreCase("initiate green poison attack")){
			DBConnection dbc = new DBConnection();
			dbc.storeToDB(sm.getSearch(), sm.getDate());
			response.sendRedirect("https://www.google.com/search?q=" + sm.getSearch());
		
		}else if(sm.getSearch().isEmpty()){
			response.sendRedirect("index.html");			
		
		}else{
			request.getRequestDispatcher("hacking.html").forward(request, response);;
		}
	}

}
