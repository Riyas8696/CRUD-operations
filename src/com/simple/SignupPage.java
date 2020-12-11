package com.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupPage")
public class SignupPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("n");
		String email = request.getParameter("e");
		String phone = request.getParameter("p");
		String un = request.getParameter("un");
		String pwd = request.getParameter("pwd");
		
		if(name.isEmpty() && email.isEmpty() && phone.isEmpty() && un.isEmpty() && pwd.isEmpty()) {
			out.println("Please fill the details properly.......");
			RequestDispatcher rd = request.getRequestDispatcher("Signuppage.html");
			rd.include(request, response);
		}
		else {
			DatabaseConnection ob = new DatabaseConnection();
			ob.dbConnect();
			ob.insertData(name, email, phone, un, pwd);
			RequestDispatcher dr = request.getRequestDispatcher("MainPage.html");
			dr.forward(request, response);
		}
	}

}
