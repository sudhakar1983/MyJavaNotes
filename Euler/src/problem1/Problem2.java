package problem1;

public class Problem2 {
	
	public static void main(String[] args) {
	
		long limit =4000000;
		
		
		long start = System.currentTimeMillis();
		//Approach 1 
		long i=0;
		long next =1;
		long temp = 0;		
		boolean counter =true;
		while(counter){
			System.out.println(next);
			temp = next;
			next = i + next; 
			i=temp;			
			if(next>limit)counter = false;
		}
		System.out.println("completed in :"+(System.currentTimeMillis()- start));
		
	}
	
	

}
