package com.problems.leetcode;
/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @author Sudhakar
 *
 */
public class DeleteNodeInALinkedList {

	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	    
	    @Override
	    public String toString() {
	    	StringBuffer s = new  StringBuffer();
	    	ListNode node = this;
	    	while(node != null){
	    		s.append(node.val).append(",");
	    		node = node.next;
	    	}
	    	return s.toString();
	    }
	  } 


	
	  static public void deleteNode(ListNode node) {
	       
	       if(null != node.next){
	           ListNode nextNode = node.next;
	           node.val=nextNode.val;
	           node.next=nextNode.next;            
	       }

	   }
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(5);
		
		ListNode node1 = new ListNode(6);
		node.next = node1;
		
		ListNode node2 = new ListNode(7);
		node1.next=node2;
		
		System.out.println(node.toString());
		
		
		deleteNode(node1);
		
		System.out.println(node.toString());
	}
	
}


  