/**
 * EmployeeRegistrationApp
 * 
 *Entry point for payslip generation.
 *
 *Execution flow:
 * - capture employee details
 * - capture salary components
 * - generate payslip via service
 * - display formatted payslip
 * 
 * @author Tulsee Agrawal
 * @version 3.0
 */

package com.app;
import com.exception.*;
import com.auth.*;
import com.session.*;
import com.model.*;
import com.service.*;
import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee emp = null; 
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
			emp = new Employee(empID, name, email, phone, account);

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

	       // ==========================
	        // USE CASE 3 - PAYSLIP
	        // ==========================
	        System.out.println("\n=== USE CASE 3: PAYSLIP GENERATION ===");

	        System.out.print("Enter Month: ");
	        String month = sc.nextLine();

	        System.out.print("Enter Basic Salary: ");
	        double basic = sc.nextDouble();

	        System.out.print("Enter HRA: ");
	        double hra = sc.nextDouble();

	        System.out.print("Enter DA: ");
	        double da = sc.nextDouble();

	        System.out.print("Enter Allowances: ");
	        double allowances = sc.nextDouble();

	        PayrollService service = new PayrollService();

	        Payslip payslip = service.generatePayslip(emp, month, basic, hra, da, allowances);

	        System.out.println(payslip);
		
		sc.close(); 
		
	}
}
