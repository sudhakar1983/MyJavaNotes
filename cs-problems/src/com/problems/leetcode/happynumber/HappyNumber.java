package com.problems.leetcode.happynumber;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
    public static boolean isHappy(int n) {
        int div = java.lang.Math.abs(n);
        
        int sum = 0;
        while(true){
            
        	while(div != 0){
        		sum = sum+ (int)java.lang.Math.pow(div%10,2);
                div = div / 10;
        	}           
        
            if(sum<=9) break;
            else{
                div = sum;
                sum = 0;
            }
            
        }
        
        if(sum == 1) return true;
        else return false;
    }
	
}
