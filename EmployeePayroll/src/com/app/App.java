
/**
 * EmployeeRegistrationApp
 * 
 * This is the main application class that demonstrates
 * Use Case 2: EMPLOYEE AUTHENTICATION & LOGIN
 * 
 * Goal of this use case:
 * - Introduce inheritance and polymorphism
 * - Show how different user types share common behaviour
 * - Demonstrate a simple authentication flow
 * 
 * New ideas introduced here:
 * - Abstract class
 * - Method overriding
 * - Runtime decision-making 
 * 
 * @author Tulsee Agrawal
 * @version 2.0
 */

package com.app;
import com.exception.*;
import com.auth.*;
import com.session.*;
import com.model.*;

import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(" USE CASE 1 : EMPLOYEE REGISTRATION  ");
		try {

			// Collect employee information from the user
			System.out.print("Enter Employee ID: (EMP-XXXX) ");
			String empID = sc.nextLine();

			System.out.print("Enter Name: ");
			String name = sc.nextLine();

			System.out.print("Enter email: ");
			String email = sc.nextLine();

			System.out.print("Enter phone: ");
			String phone = sc.nextLine();

			System.out.print("Enter UserName: ");
			String username = sc.nextLine();

			System.out.print("Enter Password: ");
			String password = sc.nextLine();

			// Validate user input using Validator utility methods
			Validator.validateEmail(email);
			Validator.validateEmpID(empID);
			Validator.validatePhone(phone);

			// Create a UserAccount object for login credentials
			UserAccount account = new UserAccount(username, password);

			// Create an Employee object using the provided details
			Employee emp = new Employee(empID, name, email, phone, account);

			// Persist employee information to file (employee_data.txt)
			emp.persist();

			// Display confirmation message
			System.out.println("Employee registered successfully");

			// Print employee details using overridden toString()
			System.out.println(emp);

		}

		// Catch validation errors (invalid email, phone, or employee ID)
		catch (ValidationException e) {
			System.out.println("\nInvalid details: " + e.getMessage());
		}

		// Catch errors that occur during file writing
		catch (IOException e) {
			System.out.println("\nError saving info");
		}
		System.out.println("    USE CASE-2 USER AUTHENTICATION AND LOGIN   ");
		AuthenticationService auth = new AuthenticationService();
	       auth.registerUser();   // user input registration
	       Session session = auth.login();  // login
	       if(session != null) {
	           System.out.println("\n" + session);
	           if(!session.isExpired()) {
	               System.out.println("Session active and valid.");
	           }
	       }

		
		
		sc.close(); 
		
	}
}
