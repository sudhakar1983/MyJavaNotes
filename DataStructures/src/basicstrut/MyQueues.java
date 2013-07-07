package basicstrut;

import java.util.Random;

public class MyQueues {
	
	private int[] arr;
	private int nElems;
	
	private int head= -1;
	private int rear= -1;
	

	public MyQueues(int size){		
		arr = new int[size];
	}
	
	public void display(){
		System.out.println("head :"+head);
		System.out.println("rear :"+rear);
		System.out.println("nElems :"+nElems);
		System.out.println("isFull :"+isFull());
		
		for(int i : arr){
			System.out.println(i);
		}
	}
	
	public boolean isEmpty(){
		return rear == -1;
	}
	
	public boolean isFull(){
		return rear+1 == head || (rear+1)% arr.length ==head;
	}
	
	public int remove(){
		if(head == -1) head =0;
		
		head = head% (arr.length);
		return arr[head++];
	}
	
	
	public void insert(int i){
		if(head == -1) head =0;
		rear = rear% (arr.length-1);
		arr[++rear] = i;
	}
	
	public static void main(String[] args) {
		Random r = new Random(20);
		int limit = 3;
		MyQueues q = new MyQueues(limit);
		while(!q.isFull()){			
			q.insert(r.nextInt(limit));
		}
		q.display();
		q.remove();q.remove();q.remove();q.insert(r.nextInt(limit));
		//q.insert(r.nextInt(limit));
		q.display();
		q.insert(r.nextInt(limit));
		q.remove();
		q.display();
	}
	
}
