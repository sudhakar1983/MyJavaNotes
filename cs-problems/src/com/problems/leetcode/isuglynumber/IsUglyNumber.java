package com.problems.leetcode.isuglynumber;

public class IsUglyNumber {

	
    public boolean isUgly(int num) {
        if(num < 1) return false;
        if(num ==1 )  return true;
        
        boolean result = true;
        
        while(num >1){
            if(num % 30 == 0){
                num = num/30 ;
            }else if(num % 2 == 0){
                num = num/2 ;
            }else if(num % 3 == 0){
                num = num/3 ;
            }else if(num % 5 == 0){
                num = num/5 ;
            }else{
                result = false;
                break;
            }
        }
        
        return result;
        
    }
}
