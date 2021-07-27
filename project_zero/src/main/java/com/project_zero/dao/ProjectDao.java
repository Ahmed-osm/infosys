package com.project_zero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project_zero.entity.ProjectUser;

public class ProjectDao implements ProjectDaoInterface {

	public int createprofiledao(ProjectUser pu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","osman");
			PreparedStatement ps=con.prepareStatement("insert into projectuser values(?,?,?,?,?)");
			ps.setString(1, pu.getName());
			ps.setString(2, pu.getPassword());
			ps.setString(3, pu.getEmail());
			ps.setString(4, pu.getAddress());
			ps.setString(5, pu.getPhone());
			i = ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

	public boolean logindao(ProjectUser pu) {
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","osman");
			PreparedStatement ps=con.prepareStatement("select *from projectuser where name=? and password=?");
			ps.setString(1,pu.getName());
			ps.setString(2,pu.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				b=true;
			}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return b;

}

	public ProjectUser viewprofile(ProjectUser pu1) {
		ProjectUser pu=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","osman");
			PreparedStatement ps=con.prepareStatement("select *from projectuser where name=?");
			ps.setString(1, pu1.getName());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				pu=new ProjectUser();
				pu.setName(res.getString(1));
				pu.setPassword(res.getString(2));
				pu.setEmail(res.getString(3));
				pu.setAddress(res.getString(4));
				pu.setPhone(res.getString(5));
				
				
			}
			
			
			
	}catch(Exception e) {
		e.printStackTrace();}
		return pu;
	}

	public int deletedao(ProjectUser pu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","osman");
			PreparedStatement ps=con.prepareStatement("delete from projectuser where name=?");
			ps.setString(1,pu.getName());
		    i=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}

	public ProjectUser viewalldao() {
		ProjectUser p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject","root","osman");
			PreparedStatement ps=con.prepareStatement("select *from projectuser");
		    ResultSet res=ps.executeQuery();
		    while(res.next()) {
		    p=new ProjectUser();
		    p.setName(res.getString(1));
		    p.setPassword(res.getString(2));
		    p.setEmail(res.getString(3));
		    p.setAddress(res.getString(4));
		    p.setPhone(res.getString(5));
		    }
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	}

