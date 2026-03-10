# UC‑6: Input Validation
## What it does
Validates all user inputs (email, phone, employee ID, password) and shows the first failure or overall success.
## Main Steps

- Read inputs
- Validate using Validator.validateAll()
- Catch specific exceptions
- Print friendly error or success message

## Key Ideas
- Centralized validation (validateAll)
- Specific exception types for each field
- Clean user messages

## Goal
Ensure all inputs meet required format before registration or login continues.
