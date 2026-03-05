package com.model.uc5;

/**
 * UC5 Payslip (simplified for dashboard display).
 * Contains only empId, month, netPay.
 */
public class Payslip {
    private final String empId;
    private final String month;    // e.g., "JAN-2026"
    private final double netPay;

    public Payslip(String empId, String month, double netPay) {
        this.empId = empId;
        this.month = month;
        this.netPay = netPay;
    }

    public String getEmpId() { return empId; }
    public String getMonth() { return month; }
    public double getNetPay() { return netPay; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payslip)) return false;
        Payslip p = (Payslip) o;
        return empId.equals(p.empId) && month.equals(p.month);
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31*h + empId.hashCode();
        h = 31*h + month.hashCode();
        return h;
    }

    @Override
    public String toString() {
        return "Payslip{empId=" + empId + ", month=" + month + ", netPay=" + netPay + "}";
    }
}