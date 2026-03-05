/*
 *  USERACCOUNT CLASS
 *  
 *  This class represents login-related information.
 *  
 *  Why this is a separate class:
 *  - Employee details and login details are different concerns.
 *  - Keeps responsibilities small and clear
 *  
 *  This introduces the idea of COMPOSITION:
 *  -An Employee has a useraccount
 */
package com.model;

public class UserAccount {

	private String username;
    private String password;

    /*
     * Constructor:
     * Creates a UserAccount object with username and password.
     */
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*
     * toString() provides readable output.
     */
    @Override
    public String toString() {
        return "UserAccount{ username='" + username + "' }";
    }

    public String getUsername() {
        return username;
    }

}
