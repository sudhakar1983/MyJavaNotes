package com.problems.leetcode.lowestcommonancestor;

import java.util.LinkedList;
import java.util.Queue;


public class LowestCommonAncestor {

	public static void main(String[] args) {


		TreeNode root = new TreeNode(6);

		TreeNode node1 = new TreeNode(2);
		root.left = node1;		
		TreeNode node2 = new TreeNode(8);
		root.right=node2;

		node1.left = new TreeNode(0);
		node1.right = new TreeNode(4);

		node2.left = new TreeNode(7);
		node2.right = new TreeNode(9);

		
		printTree(root);
		System.out.println("lowest common ancestor is " +lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9)).val) 
		
		;

	}



	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p == null || q == null || root== null)  return root;
		else if (   (p.val <=q.val  && p.val<=root.val && root.val<= q.val ) || (q.val <=p.val  && q.val<=root.val && root.val<= p.val )  ){
			return root;
		}

		return lowestCommonAncestor ((Math.min(p.val,q.val) < root.val) ? root.left :root.right , p , q );

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
