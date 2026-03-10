# UC‑3: Payslip Generation
## What it does
Generates a payslip for an employee using basic salary components and prints a formatted summary.
## Main Steps

- Capture employee details (from UC‑1 flow)
- Capture salary inputs (Month, Basic, HRA, DA, Allowances)
- Call PayrollService.generatePayslip(...)
- Print the Payslip


## Packages

- com.app – Main app (App)
- com.service – PayrollService
- com.model – Employee, Payslip, UserAccount
- com.auth – AuthenticationService (reuse from UC‑2)
- com.session – Session
- com.exception – ValidationException

## Goal
Create and display a correct payslip for a valid employee.
