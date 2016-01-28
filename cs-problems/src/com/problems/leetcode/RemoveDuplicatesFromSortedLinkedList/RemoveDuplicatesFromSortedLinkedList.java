package com.problems.leetcode.RemoveDuplicatesFromSortedLinkedList;


public class RemoveDuplicatesFromSortedLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);
		node1.next.next.next = new ListNode(3);
		node1.next.next.next.next = new ListNode(4);
		node1.next.next.next.next.next = new ListNode(4);
		
		deleteDuplicates(node1);
		System.out.println(node1);
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
        //[1,1,2,3,3,4,4]
        if(null == head || head.next == null) return head;
        
        ListNode headNode= null;
        ListNode previousNode = head;
        ListNode lastValidNode = null;
        while(null != previousNode){
            
            ListNode nextNode = previousNode.next;
            
            if(null == nextNode || null == lastValidNode || lastValidNode.val != nextNode.val ){
                    
            	if(lastValidNode == null) lastValidNode = previousNode;
            	
            	lastValidNode.next = nextNode;
            	lastValidNode = nextNode;
                     
                if(headNode == null ) headNode = lastValidNode;
            }
            
            previousNode = nextNode;
        }
        return headNode;
    }
}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val){
		this.val = val;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+ val;
	}
}