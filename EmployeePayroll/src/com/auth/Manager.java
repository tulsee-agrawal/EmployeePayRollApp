package com.auth;
import com.util.*;

public class Manager extends User{
	 public Manager(String username, String password) {
	       super(username, password, "MANAGER");
	   }
	   @Override
	   public boolean authenticate(String username, String password) {
	       if (!this.username.equals(username)) {
	           return false;
	       }
	       String hashed = PasswordUtil.hash(password);
	       return this.passwordHash.equals(hashed);
	   }
}
