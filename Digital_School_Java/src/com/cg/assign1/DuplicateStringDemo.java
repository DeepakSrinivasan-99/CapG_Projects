/* 

Assignment 2 

Find the duplicate String from String array
 
  */

package com.cg.assign1;

import java.util.HashSet;
import java.util.Set;

public class DuplicateStringDemo {

	public static void main(String[] args) {
		String[] words = {"apple","banana","orange","apple","grape","banana"};
		Set<String> set = new HashSet<>();
		Set<String> duplicates = new HashSet<>();
		
		for(String word: words) {
			if(!set.add(word)) {
				duplicates.add(word);
			}
		}
		
		System.out.println("Unique Strings are :"+set);
		System.out.println("Duplicate Strings are: "+duplicates);
	}
	
}
