
public class StringReversing {

	static String rv = "";
	
	public static void main(String[] args) {
		
		stringreverse("1234",0);
		System.out.println(rv);
		
		System.out.println("another substring");
		System.out.println(anotherReverseString("1234"));
		
		System.out.println("reverse number");
		System.out.println(reverseNumberWithoutRecurssion(123456));
	}
	
	
	public static void stringreverse(String str,int i){		
		if(i+1< str.length()){
			stringreverse( str, i+1);
		}
		
		rv = rv+str.charAt(i);		
	}
	
	
	public static String anotherReverseString(String str){		
		if(0 == str.length()) return str;		
		return str.charAt(str.length()-1)+ anotherReverseString(str.substring(0,str.length()-1));
	}
	
	
	public static long reverseNumberWithoutRecurssion(long l){		
		long revrse = 0;		
		while (l != 0){
			long remind  = l %10;
			revrse = revrse *10+ remind;		
			l = l /10;
		}
	
		return revrse;
	}
	
	
	
}
