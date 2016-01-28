package com.problems.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class MaximumDepthofBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode root = constructTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
		printTree(root);
		
		Solution s = new Solution();
		System.out.println("Max Depth : "  +s.maxDepth(root));
		
		System.out.println("Max Depth : "  +s.maxDepthUsingRecursion(root,0));
	}
	
	public static void printTree(TreeNode node){
		Queue<TreeNode> stack = new LinkedList<TreeNode>();
		
		//java.util.Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(node);
		while(!stack.isEmpty()){
			
			
			Queue<TreeNode> tempStack = new LinkedList<TreeNode>();
			while(!stack.isEmpty()){
				TreeNode element = stack.poll();
				if(null != element ){
					System.out.print(element.val+"	");
					tempStack.add(element.left);
					tempStack.add(element.right);
				}			
			}
			stack = tempStack;
			System.out.println("");
			
			
		}
		
	}
	
	public static TreeNode constructTree (int[] arr){
		TreeNode[] nodes = new TreeNode[arr.length];
		int i=0;
		for(int val : arr){
			nodes[i] = new TreeNode(arr[i]);
			i++;
		}
		
		for(int count=0;count< nodes.length ;count++){
			TreeNode parent = nodes[count];
			if(arr.length > (2*count+1)) parent.left= nodes[2*count+1] ;
			if(arr.length > (2*count+2)) parent.right= nodes[2*count+2] ;
			
		}
		
		return nodes[0];
	}
}


class Solution {
    public int maxDepth(TreeNode root) {
    	int count = -1;
		Queue<TreeNode> stack = new LinkedList<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			++count;
			Queue<TreeNode> tempStack = new LinkedList<TreeNode>();
			while(!stack.isEmpty()){
				TreeNode element = stack.poll();
				System.out.print(element != null ?element.val+"	" :"	");
				if(null != element ){					
					tempStack.add(element.left);
					tempStack.add(element.right);
				}			
			}
			stack = tempStack;
			System.out.println("");
		}    	
    	
        return count;
    }
    
    public int maxDepthUsingRecursion(TreeNode root , int level) {
		
    	if( null == root){
    		return level;
    	}else{
    		level++;
    	}
    	
    	int lvl1 = maxDepthUsingRecursion(root.left, level);
    	int lvl2 = maxDepthUsingRecursion(root.right, level);
    	
    	if( lvl2 > lvl1)  lvl1 = lvl2;
    	
        return lvl1;
    }
    
    
    //Simplified  - Learning
    //without using additional parameter
    
    public int maxDepthUsingRecursion(TreeNode root ) {
		
        if (root == null) return 0;
        int left = maxDepthUsingRecursion(root.left);
        int right = maxDepthUsingRecursion(root.right);
        return Math.max(left, right) + 1;
    }    
    
}

/**
 * Definition for a binary tree node.
 * */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 