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
		// 使用全限定名，创建一个ClassReader对象
		ClassReader classReader = new ClassReader("com.org.security.Account");
		
		// 构建一个ClassWriter对象，并设置让系统自动计算栈和本地变量大小
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
