package com.blomni.o2o.eureka;

public class Proxy implements Animal{

	private Animal a;
	
	public Proxy(Animal a){
		this.a=a;
	}
	
	@Override
	public void say() {
		this.check();
		this.a.say();
		
	}
	
	public void check(){
		System.out.println("检查能不能上网");
	}

	public static void main(String[] args) {
		Animal a=new Proxy(new Cat());
		a.say();
		
	}
}
