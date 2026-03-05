package com.model.uc5;

/** UC5 Employee (minimal identity for dashboard). */
public class Employee {
    private final String empId;
    private final String name;

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    public String getEmpId() { return empId; }
    public String getName()  { return name; }
}