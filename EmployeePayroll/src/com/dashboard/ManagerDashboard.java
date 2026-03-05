package com.dashboard;

import com.model.uc5.Employee;
import com.model.uc5.Payslip;

import java.util.List;

public class ManagerDashboard implements Dashboard {
    @Override
    public void display(List<Payslip> payslips, Employee employee) {
        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());

        int count = payslips.size();
        double total = 0.0;
        for (Payslip p : payslips) total += p.getNetPay();

        System.out.println("Payslip count : " + count);
        System.out.println("Total earnings (all slips) : " + total);
    }
}