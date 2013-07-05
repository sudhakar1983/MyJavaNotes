package problem1;

public class Problem1 {

	public static void main(String[] args) {
		
		
		//******************Approach 1****************
		long start = System.currentTimeMillis();
		int total = 0;
		int toSubtract = 0;
		
		//Complexity N/3
		int limit = 1000;		
		for(int i=3 ; i<limit ;i=i+3){
			total = total +i;
		}
		
		//Complexity N/5
		for(int i=5 ; i<limit ;i=i+5){
			total = total +i;
		}		
		
		//Complexity N/15
		for(int i=15 ; i<limit ;i=i+15){
			toSubtract = toSubtract +i;
		}			
		//9N/15   = 0.6 N
		System.out.println(total-toSubtract);
		System.out.println("Completed in "+(System.currentTimeMillis() - start));
		
		
		//******************Approach 2****************
		total = 0;
		for(int i=3 ; i<limit ;i=i+3){
			total = total +i;
		}
		
		for(int i=5 ; i<limit ;i=i+5){			
			if ( 0 != (i%3)) total = total +i;
		}		
		System.out.println(total);
		
		//******Approach 3  (after reading the PDF)*************
		/*
		 * 
		 Using binomial Series 
		 n(n+1) /2 
		 
		 
		 
		 
		 */
		
	}
	
	
}
