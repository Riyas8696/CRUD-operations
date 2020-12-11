package com.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserPage")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String s = request.getParameter("n");
		try {
			DatabaseConnection d = new DatabaseConnection();
			d.dbConnect();
			ResultSet rs = d.specificValue(s);
			while(rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String phone = rs.getString(3);
				String user_name = rs.getString(4);
				String pass = rs.getString(5);
				out.println("Name :"+name);
				out.println("Email :"+email);
				out.println("Phone :"+phone);
				out.println("User Name :"+user_name);
				out.println("Password :"+pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
