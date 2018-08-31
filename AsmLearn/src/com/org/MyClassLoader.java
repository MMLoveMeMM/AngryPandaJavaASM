package com.org;

import org.objectweb.asm.Opcodes;

public class MyClassLoader extends ClassLoader implements Opcodes{
	
	public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }
 
    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }
    
}
