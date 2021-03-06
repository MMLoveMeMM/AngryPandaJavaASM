package com.org.security;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class AddSecurityCheckClassAdapter extends ClassAdapter {

	public AddSecurityCheckClassAdapter(ClassVisitor cv) {
		super(cv);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        //当遇到operation方法时，
        if(mv != null && name.equals("operation")){
            wrappedMv = new AddSecurityCheckMethodAdapter(mv);// 需要插入修改字节码
        }
        return wrappedMv;
    }
	
}
