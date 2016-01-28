package com.problems.leetcode.invertbinarytree;

import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree {

	public static void main(String[] args) {
		
		TreeNode root = constructTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
		printTree(root);
		
		invertTree(root);
		printTree(root);
		
	}
	
	
	   public static TreeNode invertTree(TreeNode root) {
		   invert(root);		   
		   return root;
	    }
	   
	   public static void invert (TreeNode root)  {
		   
		   if(null == root) return;
		   
		   TreeNode right = root.right;
		   root.right = root.left;
		   root.left = right;
		   
		   
		   invert(root.left);
		   invert(root.right);
		   
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
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
