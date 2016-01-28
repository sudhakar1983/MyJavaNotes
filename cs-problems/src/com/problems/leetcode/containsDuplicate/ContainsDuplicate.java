package com.problems.leetcode.containsDuplicate;

import java.util.HashMap;

public class ContainsDuplicate {

	public static void main(String[] args) {
		
	}
	
    public boolean containsDuplicate(int[] nums) {
    	HashMap<Integer, Boolean> duplicates = new HashMap<Integer, Boolean>(nums.length);
        
        
        boolean isDuplicatePresent = false;
        for(int i : nums){
            if(duplicates.get(i) == null) duplicates.put(i, true);
            else {
                isDuplicatePresent = true;
                break;
            }
        }
        return isDuplicatePresent;
        
    }	
}
