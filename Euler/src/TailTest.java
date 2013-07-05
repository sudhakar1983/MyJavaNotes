
public class TailTest {

	public static void main(String[] args) {
		System.out.println(TailTest.iterate(100000));
	}
	
	public static long iterate(int n){
		if(n==1) return 1;		
		return iterate(n-1);
	}
}
