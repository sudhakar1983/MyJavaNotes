package com.problems.leetcode.NimGame;

public class NimGame {

	public static void main(String[] args) {
		System.out.println(canWinNim(4));
	}
	
	public static boolean canWinNim(int n) {
	  boolean result = true;
	  if(n % 4 == 0) result = false;
	  
	  return result;
	}
}




