package com.problems.leetcode.queueusingstacks;

import java.util.Stack;

public class QueueUsingStacks {
 public static void main(String[] args) {
	
	 MyQueue queue = new MyQueue();
	 queue.push(4);
	 queue.push(3);
	 queue.push(2);
	 queue.push(1);
	 queue.print();
	 
	 System.out.println(Math.pow(10,2));
}
}

class MyQueue {
	private Stack<Integer> stack = new Stack();
	
	public void print(){
		for(int i : stack){
			System.out.println(i);
		}
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
    	
    	Stack<Integer> tempstack = new Stack();
    	while(!stack.isEmpty()){
    		tempstack.push(stack.pop());
    	}    	
    	if(stack.isEmpty())stack.push(x);
    	
    	while(!tempstack.isEmpty()){
    		stack.push(tempstack.pop());
    	} 
    }

    // Removes the element from in front of queue.
    public void pop() {    	
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Queue is empty");
    	}     	

        stack.pop();
    }

    // Get the front element.
    public int peek() {
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Queue is empty");
    	}
    	
    	
    	return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
    
    public boolean isHappy(int n) {
        
        int div = java.lang.Math.abs(n);
        
        int sum = 0;
        while(true){
            
        	while(div != 0){
        		sum = sum+ (int)java.lang.Math.pow(div%10,2);
                div = div / 10;
        	}           
            
            if(sum<=9) break;
        }
        
        if(sum == 1) return true;
        else return false;
    }
}
