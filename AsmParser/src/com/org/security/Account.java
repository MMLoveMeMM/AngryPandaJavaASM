package com.org.security;

public class Account {
	public void operation() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("operation.....");
    }
}
