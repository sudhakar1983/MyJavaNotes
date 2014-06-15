package hashes;



public class Test {

	public static void main(String[] args) {
		char c = 's';
		System.out.println(0+c);
		
		System.out.println(0+'S');
		System.out.println(0+c-96);
		
		c = (char) (0+c-96);
		System.out.println(c);
	}
}
