package com.problems.leetcode.sametree;


public class SameTree {
	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(5);
		{
		TreeNode node1 = new TreeNode(6);
		p.left = node1;		
		TreeNode node2 = new TreeNode(7);
		p.right=node2;
		}
		TreeNode q = new TreeNode(5);
		{
		TreeNode qleft = new TreeNode(6);
		q.left = qleft;		
		TreeNode qright = new TreeNode(7);
		q.right=qright;
		}
			
		System.out.println(isSameTree( p,  q));

		}		
		
	
	
    	
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
	    
		if(p ==q ){
	    	return true;
	    }else 		
		if((null ==p && q != null) || (null ==q && p != null)  || p.val != q.val ){
	    	return false;
	    }
	    
	    return 
	    		isSameTree(p.left, q.left) && 
	    		isSameTree(p.right, q.right) ;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


