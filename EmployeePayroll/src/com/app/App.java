/**
 * EmployeeRegistrationApp
 * Use Case 5
 * Role of main();
 * - collect user input
 * - prepare data
 * - request appropriate dashboard
 * - Display dashboard
 * 
 * Execution flow:
 * - Capture employee details
 * - prepare payslip data
 * - select dashboard at runtime
 * - display dashboard output
 * 
 * @author Tulsee Agrawal
 * @version 5.0
 */

package com.app;

import com.model.uc5.Employee;
import com.model.uc5.Payslip;
import com.dashboard.Dashboard;
import com.dashboard.DashboardFactory;

import java.util.Arrays;
import java.util.List;

/** UC5 – Dashboard Display */
public class App {
    public static void main(String[] args) {
        String role = "EMPLOYEE"; // change to MANAGER for manager view
        Employee e = new Employee("EMP-1001", "Tulsee Agrawal");

        List<Payslip> list = Arrays.asList(
                new Payslip("EMP-1001", "JAN-2026", 120000.0),
                new Payslip("EMP-1001", "FEB-2026", 130000.0),
                new Payslip("EMP-1001", "MAR-2026", 140000.0),
                new Payslip("EMP-1001", "APR-2026", 150000.0),
                new Payslip("EMP-2002", "JAN-2026", 90000.0)
        );

        DashboardFactory factory = new DashboardFactory();
        Dashboard dashboard = factory.getDashboard(role);

        System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");
        System.out.println("User Role: " + role);
        System.out.println("Target Type: " + dashboard.getClass().getSimpleName());

        dashboard.display(list, e);
    }
}