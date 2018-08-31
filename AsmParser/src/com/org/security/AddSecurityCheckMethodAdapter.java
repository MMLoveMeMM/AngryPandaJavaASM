package com.org.security;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AddSecurityCheckMethodAdapter extends MethodAdapter{

	public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
		super(mv);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitCode() {
		// TODO Auto-generated method stub
		Label continueLabel = new Label();
        visitMethodInsn(Opcodes.INVOKESTATIC,"com/org/security/SecurityChecker","checkSecurity","()Z");
        //IFNE i != 0 时跳转，即true的时候跳转;visitLabel-->continueLabel处，继续执行
        visitJumpInsn(Opcodes.IFNE,continueLabel); //如果checkSecurity=false,则不发生跳转，顺序执行，下一条指令直接返回
        visitInsn(Opcodes.RETURN); // 条件不成立,直接返回
        visitLabel(continueLabel);// 插入跳转处
		super.visitCode();
	}

}
