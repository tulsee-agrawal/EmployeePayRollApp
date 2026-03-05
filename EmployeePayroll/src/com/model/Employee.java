/**
 *  EMPLOYEE CLASS
 *  
 *  This class represents an Employee entity.
 *  
 *  Core OOP concept introduced here:
 *  - Encapsulation
 *  
 *  Data is kept private and controlled through the class.
 */

package com.model;
import java.io.*;
import java.util.*;

public class Employee {
	private String empId;
	private String name;
	private String email;
	private String phone;
	
	private UserAccount account;
	
	/*
	 * Constructor is used to create a fully initialized Employee object.
	 */
	public Employee(String empId, String name,String email,String phone,UserAccount account) {
		this.empId=empId;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.account=account;
		
	}
	/*
	 * converts employee data into a readable format.
	 */
	@Override
	public String toString() {

		return "Employee ID: " + empId +
	               "\nName: " + name +
	               "\nEmail: " + email +
	               "\nPhone: " + phone +
	               "\nUsername: " + account.getUsername();

	}
	/*
	 * Saves employee data into a file.
	 * 
	 * Purpose:
	 * - Simulates persistence
	 * - Shows that objects can manage their own data
	 * 
	 */
	public void persist() throws IOException{

		 FileWriter fw = new FileWriter("employee_data.txt", true);

		    fw.write("Employee Registered Successfully:\n");
		    fw.write("Employee ID : " + empId + "\n");
		    fw.write("Name        : " + name + "\n");
		    fw.write("Email       : " + email + "\n");
		    fw.write("Phone       : " + phone + "\n");
		    fw.write("Username    : " + account.getUsername() + "\n");
		    fw.write("\n\n");
		    fw.write("Data persisted in file: employee_data.txt");
		    fw.close();

	}
}
