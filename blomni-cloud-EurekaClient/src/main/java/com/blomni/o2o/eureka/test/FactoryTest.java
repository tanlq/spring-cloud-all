package com.blomni.o2o.eureka.test;

public class FactoryTest {

	public static Animor getinstall(String name){
		Animor a=null;
		
		if(name.equals("Cat")){
			a=new Cat();
		}
		if(name.equals("Dog")){
			a=new Dog();
		}
		
		return a;
	}
}
