package com.org.time;

public class TimeStat {
	static ThreadLocal<Long> t = new ThreadLocal<>();

    public static void start() {
        t.set(System.currentTimeMillis());
    }

    public static void end(){
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getStackTrace()+" spend:" +(end - t.get()));
    }
}
