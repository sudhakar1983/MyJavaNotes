package com.problems.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 * 
 */
public class PalindromePermutation {
	
	public static void main(String[] args) {
		
		String s = "aab";		
		s="careearac";
		char arr[] = s.toCharArray();
		
		Set<Character> chars = new HashSet<Character>();
		for(char c : arr){
			 if(!chars.remove(c)){
				 chars.add(c);
			 }
		}
		
		if(chars.size()<=1){
			System.out.println("its Palindrome");
		}else{
			System.out.println("Not an palindrome");
		}
		
	}

}
