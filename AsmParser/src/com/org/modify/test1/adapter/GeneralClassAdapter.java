package com.org.modify.test1.adapter;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class GeneralClassAdapter extends ClassAdapter{

	public GeneralClassAdapter(ClassVisitor cv) {
		super(cv);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc,
			String signature, String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
		// 当是sayName方法是做对应的修改   这个地方设个断点
		if(name.equals("sayName")){
			MethodVisitor newMv = new SayNameMethodAdapter(mv);
			return newMv;
		}else{
			return mv;
		}
	}
	

}
