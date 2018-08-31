package com.org;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;
public class CreateAddOperImpl {
	
	static ClassWriter cw = new ClassWriter(0);
	
	public void usingAdd(int num1,int num2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		try {
			createImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usingImpl(num1,num2);
	}
	
	public void createImpl() throws Exception {
		
		PrintWriter printWriter = new PrintWriter(System.out);
		TraceClassVisitor visitor = new TraceClassVisitor(cw, printWriter);
	 
		visitor.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "asm/demo/AddOperImpl", null, "java/lang/Object", new String[]{"com/org/prev/AddOper"});
	 
		//添加构造方法
		/*
		 * 0 aload_0
		 * 1 invokespecial #10 <java/lang/Object/<init>()V>
		 * 4 return
		 * */
		MethodVisitor mv = visitor.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(Opcodes.ALOAD, 0);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(1, 1);
		mv.visitEnd();
	 
		// 添加add方法
		/*
		 * 0 iload_1
		 * 1 iload_2
		 * 2 iadd
		 * 3 ireturn
		 * */
		mv = visitor.visitMethod(Opcodes.ACC_PUBLIC, "add", "(II)I", null, null);
		mv.visitCode();
		mv.visitVarInsn(Opcodes.ILOAD, 1);
		mv.visitVarInsn(Opcodes.ILOAD, 2);
		mv.visitInsn(Opcodes.IADD);
		mv.visitInsn(Opcodes.IRETURN);
		mv.visitMaxs(2, 3);
		mv.visitEnd();
	 
		visitor.visitEnd();
	 
		FileOutputStream fos = new FileOutputStream(new File("D:/AddOperImpl.class"));
		fos.write(cw.toByteArray());
		fos.close();
	}
	
	public int usingImpl(int num1,int num2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		MyClassLoader classLoader = new MyClassLoader();
		Class<?> clazz = classLoader.defineClassForName("asm.demo.AddOperImpl", cw.toByteArray());
		Method addMethod;
		try {
			addMethod = clazz.getMethod("add", int.class, int.class);
			Object result = addMethod.invoke(clazz.newInstance(), num1, num2);
			if(result != null && result instanceof Integer) {
				System.out.println("\n"+num1+" + "+num2+" = "+(Integer) result);
				return (Integer)result;
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
}
