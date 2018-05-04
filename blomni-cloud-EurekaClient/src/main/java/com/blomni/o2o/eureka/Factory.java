package com.blomni.o2o.eureka; 
      
    class Cat implements Animal { // 定义子类Cat  
        @Override  
        public void say() { // 覆写say()方法  
            System.out.println("我是猫咪，喵呜！");   
        }   
    }   
      
    class Dog implements Animal { // 定义子类Dog  
      
        @Override  
        public void say() { // 覆写say()方法  
            System.out.println("我是小狗，汪汪！");   
        }   
    }   
      
    class Factory { // 定义工厂类  
        public static Animal getInstance(String className) {   
            Animal a = null; // 定义接口对象  
            if ("Cat".equals(className)) { // 判断是哪个子类的标记  
                a = new Cat(); // 通过Cat子类实例化接口  
            }   
            if ("Dog".equals(className)) { // 判断是哪个子类的标记  
                a = new Dog(); // 通过Dog子类实例化接口  
            }   
            return a;   
        }   
    }   
     