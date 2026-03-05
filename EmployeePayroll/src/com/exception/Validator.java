package com.exception;

import java.util.regex.Pattern;

/**
 * Validator (UC6) — centralizes input checks with clear error messages.
 *
 * Validations:
 *  - Email format (generic RFC-like)
 *  - Phone number (India: 10 digits, starts with 6-9)
 *  - Employee ID ("EMP-XXXX")
 *  - Password strength (min 8, upper, lower, digit, special)
 *
 * Throws specific exceptions for precise error handling.
 */
public class Validator {

    // Patterns (compiled once)
    private static final Pattern EMAIL =
            Pattern.compile("^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$");

    private static final Pattern IN_PHONE =
            Pattern.compile("^[6-9][0-9]{9}$");

    private static final Pattern EMP_ID =
            Pattern.compile("^EMP-[0-9]{4}$");

    // Password: min 8, at least 1 upper, 1 lower, 1 digit, 1 special
    private static final Pattern STRONG_PWD =
            Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!_()*\\-]).{8,}$");

    /** Email check — throws EmailValidationException on failure. */
    public static void validateEmail(String email) throws EmailValidationException {
        if (email == null || email.isBlank() || !EMAIL.matcher(email).matches()) {
            throw new EmailValidationException("Invalid email format. Example: user@example.com");
        }
    }

    /** Phone check — throws PhoneValidationException on failure. */
    public static void validatePhone(String phone) throws PhoneValidationException {
        if (phone == null || !IN_PHONE.matcher(phone).matches()) {
            throw new PhoneValidationException("Invalid phone number. Expect 10 digits starting with 6-9.");
        }
    }

    /** Employee ID check — throws EmpIdValidationException on failure. */
    public static void validateEmpID(String empId) throws EmpIdValidationException {
        if (empId == null || !EMP_ID.matcher(empId).matches()) {
            throw new EmpIdValidationException("Invalid employee ID. Expected format: EMP-0000");
        }
    }

    /** Password strength check — throws PasswordValidationException on failure. */
    public static void validatePassword(String password) throws PasswordValidationException {
        if (password == null || !STRONG_PWD.matcher(password).matches()) {
            throw new PasswordValidationException("Weak password. Min 8 chars with at least 1 uppercase, 1 lowercase, 1 digit, 1 special.");
        }
    }

    /**
     * Combined validation (optional convenience): validates all fields.
     * Any failure throws the specific exception first encountered.
     */
    public static void validateAll(String email, String phone, String empId, String password)
            throws ValidationException {
        validateEmail(email);
        validatePhone(phone);
        validateEmpID(empId);
        validatePassword(password);
    }
}