package com.problems.leetcode;

public class AddDigits_258 {

	public static void main(String[] args) {
		
		
		
		System.out.println(addDigits(5));
		System.out.println(addDigits(10));
		System.out.println(addDigits(155));
		System.out.println(addDigits(275));
		
		
		/*
		System.out.println(recursiveSolution(5,0));
		System.out.println(recursiveSolution(10,0));
		System.out.println(recursiveSolution(-155,0));
		System.out.println(recursiveSolution(275,0));
		*/		
		
	}
	
    public static int addDigits(int num) {
        
    	int sum = 0;
    	int dividend = num;
    	do{
    		
    		
    		sum = sum + (dividend % 10); // 5   --> 10 -->11  -->  12
    		dividend = dividend / 10;   // 15   --> 1 --> 0    -->
    		
    		if(dividend == 0 &&  (sum) > 9) {
    			dividend = sum;
    			sum=0;
    		}
    		
    	}while( dividend > 0);
    	
    	return sum;
    }

    
    public static int recursiveSolution(int num , int sum){
    	if( num ==0 && sum < 10){
    		return sum;
    	}else if( num ==0 && sum >9){
    		num = sum;
    		sum = 0;
    	}    	    	
    	return recursiveSolution( num /10  , sum + (num % 10));
    		    		
    }
    
}
