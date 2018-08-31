package com.org;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AopClassAdapter extends ClassVisitor implements Opcodes{

	public AopClassAdapter(int api, ClassVisitor cv) {
		super(api, cv);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        // 对test开头的方法进行特殊处理
        if (name.startsWith("test")) {
            mv = (MethodVisitor) new AopMethodVisitor(this.api, mv);
        }
        return mv;
    }

}
