package com.org.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class AddCondition2Code {

	public void addCondition2Code() throws Exception {
		// ʹ��ȫ�޶���������һ��ClassReader����
		ClassReader classReader = new ClassReader("com.org.security.Account");
		
		// ����һ��ClassWriter���󣬲�������ϵͳ�Զ�����ջ�ͱ��ر�����С
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
		classReader.accept(classAdapter, ClassReader.SKIP_DEBUG);
		
		byte[] classFile = cw.toByteArray();
		File file = new File("D://Account.class");
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(classFile);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
