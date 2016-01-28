package com.problems.leetcode.ExcelColumnSheetNumber;

import java.util.HashMap;

/***
 * Basically Base26 - figured out on my own :-)
 * 
 * A	1
 * 
 * AA	27
 * 
 * BA   (26^1 * 2 )+  (26^0 * 1)
 * 
 * ZA   (26^1 * 26  ) + (26^0 * 1)
 * 
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * @author Sudhakar
 *
 */

public class ExcelColulmnSheetNumber {

	private static HashMap<String, Integer> alphabetsValue = new HashMap<String, Integer>(26);
	
	public static void main(String[] args) {
		
	}
	
	  public int titleToNumber(String s) {
	  
		  
		  return 0;
	   }
}
