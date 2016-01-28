package com.problems.leetcode.movezeros;

import java.util.ArrayList;
/**
 * https://leetcode.com/problems/move-zeroes/
 * @author Sudhakar
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		
		moveZeroes(new int[]{0, 1, 0, 3, 12});
	}
	
	
	/**
	 * O(n) solution - based on 2 pointer approach
	 * 
	 * and concentrates on moving the non-zeros to the zeros place
	 */
	public static void moveZeroes(int[] nums) {
	    int i = -1, j = 0;
	    while (j < nums.length) {
	        if (nums[j] != 0) {
	            swap(++i, j, nums);
	        }
	        j++;
	    }
	}
	public static void swap(int i, int j, int[] nums) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}	
	
	
	/**
	 * Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

I was moving the zeros
	 * @param nums
	 */
	//O(n^2) without copy arrays 
    public static void moveZeroes_old(int[] nums) {
        
    	for(int i=0;i< nums.length ; i++){
    		
    		if(nums[i] == 0){
    			int emptyIndex = i;
    			for(int j=i+1; j< nums.length ; j++){    				
    				if(nums[j] !=0){
    					nums[emptyIndex] = nums[j];
    					emptyIndex = j; 
    					
    				}    				
    			} 
    			nums[emptyIndex] = 0;
    		}    		
    	}
    	
       	//print
    	for(int i : nums){
    		System.out.print(i+" ");
    	}
    }	
	
    
    
	
	
	//O(n) but uses copy arrays
    public static void moveZeroes1(int[] nums) {
        
    	java.util.List<Integer> finalList = new ArrayList<Integer>(nums.length);
    	
    	int count = 0;
    	for(int i :  nums){
    		if(i != 0){
    			finalList.add(i); count++;
    		}
    	}
    	
    	//Padd zeros for the rest of the positions
    	for(int i = count ; i < nums.length;i++){
    		finalList.add(0);
    	}
    	
    	//print
    	for(int i : finalList){
    		System.out.println(i+" ");
    	}
    }
}
