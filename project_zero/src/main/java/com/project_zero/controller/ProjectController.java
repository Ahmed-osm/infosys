package com.project_zero.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.project_zero.dao.ProjectDaoInterface;
import com.project_zero.entity.ProjectUser;
import com.project_zero.utility.DaoFactory;

public class ProjectController implements ProjectControllerInterface {
	private BufferedReader br;
	ProjectDaoInterface pd;
	public ProjectController(){
		br=new BufferedReader(new InputStreamReader(System.in));
		pd= DaoFactory.createObject();
	}

	public void createprofile() {
		try {
		System.out.println("Enter your name");
		String name=br.readLine();
		System.out.println("Enter your password");
		String password=br.readLine();
		System.out.println("Enter your email address");
		String email=br.readLine();
		System.out.println("Enter your address");
		String address=br.readLine();
		System.out.println("Enter your phone no");
		String phone=br.readLine();
		ProjectUser pu=new ProjectUser();
		pu.setName(name);
		pu.setPassword(password);
		pu.setEmail(email);
		pu.setAddress(address);
		pu.setPhone(phone);
		
		
		int i=pd.createprofiledao(pu);
		
		if(i>0) {
			System.out.println("Profile created successfully");
		}
		else {
			System.out.println("Could not create profile");
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	public void loginprofile() {
		try {
		System.out.println("*******Login page********");
		System.out.println("Enter your name:");
		String name=br.readLine();
		System.out.println("Enter your Password:");
		String password=br.readLine();
		ProjectUser pu=new ProjectUser();
		pu.setName(name);
		pu.setPassword(password);
		boolean b=pd.logindao(pu);
		if(b) {
			System.out.println("Logged in successfully");
		}
		else {
			System.out.println("Login Failed");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewprofile() {
		try {
			System.out.println("*******View profile********");
			System.out.println("Enter name to view profile:");
			String name=br.readLine();
			
			
			ProjectUser pu=new ProjectUser();
			pu.setName(name);
			ProjectUser pu1=pd.viewprofile(pu);
			if(pu1!=null) {
				System.out.println("The Record for "+pu1.getName());
				System.out.println("Password : "+pu1.getPassword());
				System.out.println("Email : "+pu1.getEmail());
				System.out.println("Address : "+pu1.getAddress());
				System.out.println("Contact : "+pu1.getPhone());
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void editprofile() {
		
	try {
		System.out.println("*****Edit Profile*****");
		System.out.println("Enter name to edit profile");
		String name=br.readLine();
		ProjectUser pu=new ProjectUser();
		pu.setName(name);
		
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		

	}

	public void deleteprofile() {
		try {
			System.out.println("Enter name to delete profile");
			String name=br.readLine();			
			
			ProjectUser pu=new ProjectUser();
			pu.setName(name);
			
		    int i=pd.deletedao(pu);
		    if(i>0) {
		    	System.out.println("Profile Deleted Successfully");
		    }else {
		    	System.out.println("culd");
		    }
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void viewallprofile() {
		try {
			System.out.println("****All Records****");
			ProjectUser pu2=new ProjectUser();
			pu2=pd.viewalldao();
		
				System.out.println("Name:"+pu2.getName());
				System.out.println("Password:"+pu2.getPassword());
				System.out.println("Email:"+pu2.getEmail());
				System.out.println("Address:"+pu2.getAddress());
				System.out.println("Phone:"+pu2.getPhone());
				
			
			
			
		}catch(Exception e) {
	e.printStackTrace();
}

	}

}
