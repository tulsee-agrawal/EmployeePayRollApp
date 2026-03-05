package com.dashboard;

public class DashboardFactory {
    public Dashboard getDashboard(String role) {
        if (role == null) return new EmployeeDashboard();
        if ("MANAGER".equalsIgnoreCase(role))  return new ManagerDashboard();
        return new EmployeeDashboard();
    }
}
