package com.problems.leetcode.shortestworddistance;
/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * @author Sudhakar
 *
 */
public class ShortestWordDistance {

	public static void main(String[] args) {
		
		String[] arr = { "practice", "makes", "perfect", "coding", "makes" };
		
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(arr);
		System.out.println(shortestPath (arr,word1,word2)) ;
		
		String[]  arr1 = { "practice", "makes", "makes","perfect", "coding", "makes" };
		System.out.println(arr1);
		System.out.println(shortestPath (arr1,"makes","coding")) ;
		
		
		String[]  arr2 = { "practice", "makes", "perfect", "coding","coding", "makes" };
		System.out.println(arr2);
		System.out.println(shortestPath (arr2,"perfect","coding")) ;

		
		
	}
	
	//O(n) approach , with pointer-like based comparison
	//Less efficient approach would be to have 2 loops , 
	//outerloop for word1 and inner loop to find the other word2
	//Repeat the outerloop for word2 and inner loop to find word1
	private static int shortestPath (String [] arr , String word1 , String word2){
		int diff=Integer.MAX_VALUE;
		String word = null;
		int wordIndex = -1;
		
		for(int i = 0; i < arr.length ; i++){
			String temp = arr[i];
			if(temp.equals(word1) || temp.equals(word2)){
				
				if(null == word || word.equals(temp)){
					word = temp;
					wordIndex = i;
				}else if( null != word && !word.equals(temp)){
					int newDiff = i - wordIndex;
					if(newDiff < diff )  diff = newDiff;
					
					word = temp;
					wordIndex = i;
				}				
			}
		}
		return diff;
	}
}
