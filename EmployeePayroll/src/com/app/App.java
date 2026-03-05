
/**
 * EmployeeRegistrationApp
 * 
 * This is the main application class that demonstrates
 * Use Case 1: Employee Registration.
 * 
 * Responsibilities:
 * - Collect employee details from the user
 * - Validate inputs using the Validator class
 * - Create UserAccount and Employee objects
 * - Persist employee data to a file
 * - Handle validation and IO exceptions
 * 
 * @author Tulsee Agrawal
 * @version 1.0
 */

package com.app;
import com.exception.*;
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

		// Finally block always executes to release resources
		finally {
			sc.close(); // Close scanner to avoid resource leaks
		}
	}
}
