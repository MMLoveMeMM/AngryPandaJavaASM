package com.org.security;

public class SecurityChecker {
	
	public static boolean checkSecurity() {
        System.out.println("SecurityChecker.checkSecurity.....");
        /**
         * 简单模拟“安全校验”
         * 当前系统时间，尾数如果是偶数,则结果是1，如果是奇数则结果是0
         */
        if ((System.currentTimeMillis() & 0x1) == 0) {
            return false;
        } else {
            return true;
        }
    }
	
}
