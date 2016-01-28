package com.problems.leetcode.RomanToInteger;

import java.util.HashMap;
import java.util.TreeMap;

public class RomanToInteger {

	public static void main(String[] args) {
		
		System.out.println(romanToInt("DIX"));
		
		System.out.println(intToRoman(509));
		
	}
	
    public static int romanToInt(String s) {
    	int number = 0;
    	
		HashMap<Character, Integer> romans = new HashMap<Character, Integer>();
		romans.put('I', 1);
		romans.put('V', 5);
		romans.put('X', 10);
		romans.put('L', 50);
		romans.put('C', 100);
		romans.put('D', 500);
		romans.put('M', 1000);
		
		String romanStr = s.toUpperCase();
		
		for(int i = 0; i < romanStr.length();i++){
			
			if(i < romanStr.length()-1 && romans.get(romanStr.charAt(i)) < romans.get(romanStr.charAt(i+1)) ){
				number = number - romans.get(romanStr.charAt(i)) ;
			}else{
				number = number + romans.get(romanStr.charAt(i)) ;
			}
			
		}
			
			
		return number;
        
    }
    
    
    public static String intToRoman(int number) {
    	String romanStr="";
    	
		TreeMap<Integer,String> romans = new TreeMap<Integer,String>();
		romans.put(1, "I");
		romans.put(4, "IV");
		romans.put(9, "IX");
		romans.put(5, "V");
		romans.put(10, "X");
		romans.put(50, "L");
		romans.put(100, "C");
		romans.put(500, "D");		
		romans.put(1000, "M");
		
		int dividend = number;
		for(int divisor : romans.descendingKeySet()){
			int romanNum = dividend /divisor ;			
			dividend = dividend % divisor;
			
			
			while(romanNum > 0){
				romanStr = romanStr+romans.get(divisor);
				--romanNum;
			}
		
		}
			
		return romanStr;
        
    }
}
