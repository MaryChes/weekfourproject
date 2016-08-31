package com.weekfourprojectservlets;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekfourproject.DAO;
import com.weekfourproject.Movie;

/**
 * Servlet implementation class addToDB
 */
@WebServlet("/addToDB")
public class addToDB extends HttpServlet 
{
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	Connection conn = null;
	Statement stmt = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try 
		{
			Class.forName("JDBC_Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String orderBy = request.getParameter("sort");
			
			if ((orderBy == null) || orderBy.equals(""))
			{
				orderBy = "movie_id";
			}
			String orderByDir = request.getParameter("sortdir");
			if ((orderByDir == null) || orderByDir.equals(""))
			{
				orderByDir = "asc";
			}
			String query = "Select "
				
			
			
			
		}//try
		
	}//doGet

    
    public addToDB() 
    {
    	super ();
        // TODO Auto-generated constructor stub
    }//end method

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Movie addToDB = new Movie();
		
		addToDB.setMovieTitle(request.getParameter("title"));
		addToDB.setMovieRating(request.getParameter("rating"));
		addToDB.setMovieGenre(request.getParameter("genre"));
		addToDB.setMovielength(request.getParameter("length"));
		
		DAO.writeToDB(addToDB);
	}//doPost

}//end class
