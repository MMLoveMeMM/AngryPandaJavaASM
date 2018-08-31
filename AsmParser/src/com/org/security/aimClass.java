package com.org.security;

public class aimClass {
	public void operation() throws InterruptedException{
        if(SecurityChecker.checkSecurity()){
            System.out.println("operation.....");
        }   
    }
}
