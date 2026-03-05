package com.dashboard;

import com.model.uc5.Employee;
import com.model.uc5.Payslip;
import java.util.List;

public interface Dashboard {
    void display(List<Payslip> payslips, Employee employee);
}