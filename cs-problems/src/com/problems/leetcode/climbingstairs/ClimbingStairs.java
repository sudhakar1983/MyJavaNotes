package com.problems.leetcode.climbingstairs;

public class ClimbingStairs {

	public static void main(String[] args) {	
		System.out.println(climbStairs(5));
		

	}
	
    public static int climbStairs(int n) {
		if (n<3){return n;}
		int f1=1;
		int f2=2;
		for (int i=3;i<=n;i++){
		f2=f1+f2;
		f1=f2-f1;
		}
		return f2;
    }
    
    public static int recursiveclimbStairs(int n) {
    	if(n<=2) return n;
    	return recursiveclimbStairs(n-1)+recursiveclimbStairs(n-2);
    }
	
}
