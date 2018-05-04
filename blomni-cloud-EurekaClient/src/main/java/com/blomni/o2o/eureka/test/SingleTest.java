package com.blomni.o2o.eureka.test;

public class SingleTest {
	
		public SingleTest(){
			
		}
		public static SingleTest single;
		
		public synchronized static SingleTest getinstall(){
			
			if(single==null){
				synchronized (SingleTest.class) {
					if(single==null){
						single=new SingleTest();
					}
				}
			}
			
			return single;
		}
}
