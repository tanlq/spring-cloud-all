package com.blomni.o2o.eureka;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrantLock {

	private Lock lock=new ReentrantLock(false);
	
	public void testMethod(){
		lock.lock();
		try {
			for (int j = 0; j <100; j++) {
				System.out.println("ThreadName=" + Thread.currentThread().getName()
			            + (" " + (j + 1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		TrantLock locka=new TrantLock();
		locka.testMethod();
		
	}
}
