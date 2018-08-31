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
        //IFNE i != 0 ʱ��ת����true��ʱ����ת;visitLabel-->continueLabel��������ִ��
        visitJumpInsn(Opcodes.IFNE,continueLabel); //���checkSecurity=false,�򲻷�����ת��˳��ִ�У���һ��ָ��ֱ�ӷ���
        visitInsn(Opcodes.RETURN); // ����������,ֱ�ӷ���
        visitLabel(continueLabel);// ������ת��
		super.visitCode();
	}

}
