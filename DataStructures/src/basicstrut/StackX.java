package basicstrut;

public class StackX {

	private int[] arr;
	private int top = -1;
	
	public StackX(int size){
		arr = new int[size];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == arr.length-1 ;
	}
	
	public void push(int i){
		if(isFull()) throw new RuntimeException("Stack is Full");
		arr[++top] = i;
	}
	
	public int pop (){
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		return arr[top--];
	}
	
	
	public static void main(String[] args) {
		StackX s = new StackX(5);
		
		s.push(1);s.push(2);s.push(3);s.push(4);s.push(5);
		
		try {
			s.push(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());System.out.println(s.pop());System.out.println(s.pop());
		
				
		try {
			System.out.println(s.pop());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
