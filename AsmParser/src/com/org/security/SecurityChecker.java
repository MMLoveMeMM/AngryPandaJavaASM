package com.org.security;

public class SecurityChecker {
	
	public static boolean checkSecurity() {
        System.out.println("SecurityChecker.checkSecurity.....");
        /**
         * ��ģ�⡰��ȫУ�顱
         * ��ǰϵͳʱ�䣬β�������ż��,������1�����������������0
         */
        if ((System.currentTimeMillis() & 0x1) == 0) {
            return false;
        } else {
            return true;
        }
    }
	
}
