package com.mvc;

class Test{
	public String name;

	public Test(String name) {
		this.name = name;
		this.printName();
	}
	
	public void printName() {
		System.out.println("아빠  :"+ name);
	}
}

public class Constructor2 extends Test {

	public Constructor2(String name) {
     super(name);
	}
     public void printName() {
    	 super.printName();
 		System.out.println("아들  :"+ name);
 	}
 }
class Excute{
	public static void main(String[] args) {
		Constructor2 cotr2 = new Constructor2("hello");
	
	}
}



