package com.problems.leetcode.numberof1bits;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * @author Sudhakar
 *
 */
public class NumberOf1Bits {
	public static void main(String[] args) {

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);

		// System.out.println(hammingWeight( 2147483648L));
		System.out.println(hammingWeight(2147483647));
		
	}
	
	//Learning
	
	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static int hammingWeight(long n) {
		int count = 0;
		long div = n;
		ArrayList<Integer> arr = new ArrayList<Integer>(32);
		while (div != 0) {

			if (div % 2 == 1) {
				++count;
				arr.add(1);
			} else {
				arr.add(0);
			}
			div = div / 2;

		}

		for (int i : arr) {
			System.out.print(i);
		}

		return count;
	}
}
