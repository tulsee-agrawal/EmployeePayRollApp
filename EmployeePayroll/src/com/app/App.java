/**
 * EmployeeRegistrationApp
 * UC6 – Input Validation 
 *
 * Flow:
 *  1) Read input
 *  2) Validate (email, phone, empId, password)
 *  3) Print success or first failure with a friendly message
 *
 * 
 * @author Tulsee Agrawal
 * @version 6.0
 */

package com.app;

import com.exception.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6: INPUT VALIDATION ===");

        System.out.print("Enter Email         : ");
        String email = sc.nextLine();

        System.out.print("Enter Phone         : ");
        String phone = sc.nextLine();

        System.out.print("Enter Employee ID   : ");
        String empId = sc.nextLine();

        System.out.print("Enter Password      : ");
        String password = sc.nextLine();

        try {
           
            Validator.validateAll(email, phone, empId, password);

            System.out.println("All inputs are VALID.");
            System.out.println("Registration/Login can proceed.");

        } catch (EmailValidationException e) {
            System.out.println("Email error: " + e.getMessage());
        } catch (PhoneValidationException e) {
            System.out.println("Phone error: " + e.getMessage());
        } catch (EmpIdValidationException e) {
            System.out.println("Employee ID error: " + e.getMessage());
        } catch (PasswordValidationException e) {
            System.out.println("Password error: " + e.getMessage());
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        sc.close();
    }

}