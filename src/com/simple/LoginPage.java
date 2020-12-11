package com.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String u = null;
	String p = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String un = request.getParameter("un");
		String pwd = request.getParameter("pwd");
		
		DatabaseConnection d = new DatabaseConnection();
		d.dbConnect();
		ResultSet res = d.getSelectValue();
		try {
			while(res.next()) {
				u = res.getString("username");
				p = res.getString("password");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
		if(un.equals("admin") && pwd.equals("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("Admin.html");
			rd.forward(request, response);
		}
		else if(un.equals(u) && pwd.equals(p)) {
			RequestDispatcher dr = request.getRequestDispatcher("Userpage.html");
			dr.forward(request, response);
		}
		else {
			out.println("Please enter correct username and password....");
			RequestDispatcher dr = request.getRequestDispatcher("MainPage.html");
			dr.include(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
