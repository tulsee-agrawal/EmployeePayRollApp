package com.dashboard;

import com.model.uc5.Employee;
import com.model.uc5.Payslip;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDashboard implements Dashboard {
    @Override
    public void display(List<Payslip> payslips, Employee employee) {
        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        // Filter for this employee, sort by month desc (string-based)
        List<Payslip> sorted = payslips.stream()
                .filter(p -> p.getEmpId().equals(employee.getEmpId()))
                .sorted(Comparator.comparing(Payslip::getMonth).reversed())
                .collect(Collectors.toList());

        System.out.println("\nRecent Payslips (Top 3):");
        sorted.stream().limit(3).forEach(p ->
                System.out.println(" - " + p.getMonth() + " : " + p.getNetPay()));

        double total = sorted.stream().mapToDouble(Payslip::getNetPay).sum();
        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}