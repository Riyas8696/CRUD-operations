package com.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
	
	public Connection con = null;
	public PreparedStatement ps = null;
	public PreparedStatement ps1 = null;
	public PreparedStatement ps2 = null;
	public PreparedStatement ps3 = null;
	public ResultSet rs = null;
	public ResultSet rs1 = null;
	public ResultSet rs2 = null;
	public ResultSet rs3 = null;
	
	public Connection dbConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			//System.out.println("Connected.........");
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insertData(String a,String b,String c,String d,String e) {
		try {
			ps = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setString(5, e);
			int x = ps.executeUpdate();
			/*if(x>0) {
				System.out.println("Inserted.............");
			}
			else {
				System.out.println("Not Inserted...........");
			}*/
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ResultSet selectData() {
		try {
			ps1 = con.prepareStatement("select * from employee");
			rs = ps1.executeQuery();
			return rs;
		}
		catch(Exception e1) {
			e1.printStackTrace();
			return null;
		}
	}
	
	public ResultSet specificSelectMethod() {
		try {
			ps = con.prepareStatement("select name from employee");
			rs1 = ps.executeQuery();
			return rs1;
		}
		catch(Exception e2) {
			e2.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getSelectValue() {
		try {
			ps2 = con.prepareStatement("select username,password from employee");
			rs2 = ps2.executeQuery();
			return rs2;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet specificValue(String s) {
		try { 
			ps3 = con.prepareStatement("select * from employee where name ='"+s+"'");
			rs3 = ps3.executeQuery();
			return rs3;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
