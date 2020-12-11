package com.simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String select = request.getParameter("s");
		if(select.equals("user")) {
			try {
				DatabaseConnection d = new DatabaseConnection();
				d.dbConnect();
				ResultSet rs = d.specificSelectMethod();
				while(rs.next()) {
					String name = rs.getString(1);
					out.println("User Name is :"+name+"<br>");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(select.equals("admin")) {
			try {
				DatabaseConnection c = new DatabaseConnection();
				c.dbConnect();
				ResultSet rs = c.selectData();
				while(rs.next()) {
					String name = rs.getString(1);
					String email = rs.getString(2);
					String phone = rs.getString(3);
					String user_name = rs.getString(4);
					String password = rs.getString(5);
					out.println(name+" "+email+" "+phone+" "+user_name+" "+password+"<br>");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
