package com.mvc;

public class Constructor {
	int num;
	public Constructor() {
	
		System.out.println(num);
	}
	public Constructor(int num) {
		System.out.println(num);
		this.num =num;
		
	}
	
	
	void test() {
		System.out.println(" 나 이미 머리 속에 있어서 생성자에서 호출됨!");
	}
}

class Execute {
	public static void main(String[] args) {
		Constructor c = new Constructor(100);
		System.out.println(c.num);
	}
}