package com.problems.leetcode.ReverseLinkedList;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		
		ListNode node2 = new ListNode(4);
		node2.next = new ListNode(5);
		node2.next.next = new ListNode(6);		
		
		//reverseList(node1);
		//ListNode rootNode = mergeTwoLists(node1, node2);
		ListNode rootNode = new ListNode(0);
		recursiveMergeLists(node1, node2, rootNode);
		rootNode = rootNode.next;
		while(rootNode != null){
			System.out.println(rootNode.val);
			rootNode = rootNode.next;
		}
	}
	
	// 1 --> 2 --> 3 
	// 4 --> 5 --> 6
	//Recursive solution
	public static void recursiveMergeLists(ListNode l1, ListNode l2 , ListNode root){
		if(l1 != null && l2 != null){
            if(l1.val <= l2.val ){
            	root.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
            	root.next = new ListNode(l2.val);
                l2 = l2.next;
            }
		}else{
            if(l1 == null) {
                l1 = l2;
            }	              
            //Copy all remaining elements
            root.next = l1;
            l2 = null;l1 = null;
            return ;
        }
		recursiveMergeLists(l1, l2, root.next);
	}
	
	  public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	      
	      if(l1 == null) return l2;
	      else if(l2 == null) return l1;
	      
	    
	      ListNode newNode = new ListNode(0);
	      ListNode rootNode = newNode;
	      while(true){
	          
	          if(l1 != null && l2 != null){
	        	  
	               if(l1.val <= l2.val ){
	                   newNode.next = new ListNode(l1.val);
	                   l1 = l1.next;
	               }else{
	                   newNode.next = new ListNode(l2.val);
	                   l2 = l2.next;
	               }
	               
	               newNode = newNode.next;
	          }else{
	              if(l1 == null) {
	                  l1 = l2;
	              }	              
	              //Copy all remaining elements
	              newNode.next = l1;
	              l2 = null;l1 = null;
	          }
	          
	           if(l1 == null && l2 == null)  break;
	          	          
	      }
	      
	       return rootNode.next ;
	    }
	
	
	public static ListNode recursive(ListNode head){
		recursion (null , head.next);
		return head;
	}

	public static ListNode recursion( ListNode previous ,ListNode current){
		if(current == null){
			return previous;
		}
		ListNode temp = current.next;
		current.next = previous;
		
		return recursion(current, temp);
	}
	
    public static ListNode reverseList(ListNode head) {
        
        if(null == head || head.next == null) return head;

        ListNode nextNode = head.next;
        ListNode previousNode = head;
        previousNode.next=null;
        while(null != nextNode){
            
           ListNode temp  =  nextNode.next;
           nextNode.next = previousNode;
           previousNode = nextNode;
           nextNode = temp;
            
        }
        return previousNode;
        
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}