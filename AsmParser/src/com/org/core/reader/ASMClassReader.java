package com.org.core.reader;

import java.io.IOException;

import org.objectweb.asm.ClassReader;

public class ASMClassReader {

	/*
	 * 打印类所有相关的信息
	 * */
	public void readerInfo() {
		ClassPrinter cp = new ClassPrinter();
		ClassReader cr = null;
		try {
			cr = new ClassReader("com.org.Calculate"/*"java.lang.Runnable"*/);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cr.accept(cp, 0);
	}
	
}
