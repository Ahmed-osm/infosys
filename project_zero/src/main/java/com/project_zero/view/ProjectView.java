package com.project_zero.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.project_zero.controller.ProjectControllerInterface;
import com.project_zero.utility.ControllerFactory;

public class ProjectView {

	public static void main(String[] args) {
		String s="y"; 
		while(s.equals("y")) 
		{
		System.out.println("*****Main menu******");
		System.out.println("Press 1 to Create profile");
		System.out.println("Press 2 to Login profile");
		System.out.println("Press 3 to View profile");
		System.out.println("Press 4 to Edit/Update prfile");
		System.out.println("Press 5 to Delete profile");
		System.out.println("Press 6 to ViewAll profile");
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int c= Integer.parseInt(br.readLine());
		
		ProjectControllerInterface pc= ControllerFactory.createObject();
		
		switch(c) {
		
		case 1: pc.createprofile();
		break;
		case 2: pc.loginprofile();
		break;
		case 3: pc.viewprofile();
		break;
		case 4: pc.editprofile();
		break;
		case 5: pc.deleteprofile();
		break;
		case 6: pc.viewallprofile();
		break;                                       
		
		default: System.out.println("Please enter the correct option");	
		
		}
		System.out.println("Do you want to continue y/n");
		s=br.readLine();                          
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	}}
