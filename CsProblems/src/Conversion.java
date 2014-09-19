
public class Conversion {

	
	
	public static void  main(String args[]){
		
		System.out.println(convertToBinary(5));
		
		printFibonacci();
		System.out.println("Sum of digit -->" +printSum(123));
		;
	}
	
	
	public static String convertToBinary(long number){
		String ret ="";		
		while(number !=0){
			long rem = number % 2;
			ret = rem +ret ;
			number = number / 2 ;			
		}		
		return ret;		
	}
	
	
	public static void printFibonacci(){
		System.out.println("Printing Fibonacci series");
		
		int n =10;
		int a = 0 , j =1;
		int temp =0;

		for(int i=0 ; i< n ;i++){
			System.out.println(a);
			temp = j;
			j = j + a;
			a = temp;			
		}		
		
		System.out.println("fibo completed !!");
	}
	
	public static long printSum(long n){		
		if(n == 0) return 0; 
		
		return (n%10)+ printSum(n/10);
	}
	
	
}
