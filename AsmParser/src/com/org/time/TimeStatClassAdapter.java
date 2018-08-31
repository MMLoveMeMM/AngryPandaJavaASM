package com.org.time;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class TimeStatClassAdapter extends ClassAdapter{

	public TimeStatClassAdapter(ClassVisitor cv) {
		super(cv);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        //判断，如果是operation方法时，使用适配方法
        if (mv != null && name.equals("operation")) {
            wrappedMv = new TimeStatMethodAdapter(mv);
        }
        return wrappedMv;
    }

}
