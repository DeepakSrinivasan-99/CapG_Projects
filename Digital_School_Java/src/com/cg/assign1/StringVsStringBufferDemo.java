package com.cg.assign1;

//Create demo which justify difference between String and StringBuffer

public class StringVsStringBufferDemo {

	public static void main(String[] args) {
		
		//string immutable
		String str = "Hello";
		str.concat("World");
		System.out.println("String Immutable :"+str);
		
		//stringbuffer-mutable
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append(" World");
		System.out.println("StringBuffer Mutable : "+sb);
		
		
	}

	
}
