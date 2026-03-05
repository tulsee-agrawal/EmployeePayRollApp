package com.service;

import com.model.Payslip2;
import java.io.*;

public class FileService {

    /*
     * Saves payslip as a TXT file
     */
    public String savePayslipAsText(Payslip2 payslip) throws IOException {

        String filename = "Payslip_" + payslip.getEmpId() + "_" 
                + System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(filename);
        fw.write(payslip.toString());
        fw.close();

        return filename;
    }

    /*
     * Saves payslip as a PDF file (simple text stub)
     */
    public String savePayslipAsPDF(Payslip2 payslip) throws IOException {

        String filename = "Payslip_" + payslip.getEmpId() + "_" 
                + System.currentTimeMillis() + ".pdf";

        FileWriter fw = new FileWriter(filename);
        fw.write("=== PDF PAYSLIP ===\n");
        fw.write(payslip.toString());
        fw.close();

        return filename;
    }
}