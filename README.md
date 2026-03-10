# UC‑5: Dashboard Display
## What it does
Shows a role‑based dashboard (Employee or Manager) using the same data, selected at runtime.
## Main Steps

- Collect role (EMPLOYEE / MANAGER)
- Prepare employee + payslip data
- Get dashboard from DashboardFactory
- Display dashboard output

## Key Ideas
- Runtime selection via Factory (DashboardFactory)
- Polymorphism with Dashboard interface
- Single display() method, different behavior per role

## Goal
Render the correct dashboard for the user’s role with the same input data.
