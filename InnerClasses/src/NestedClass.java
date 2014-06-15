import java.util.List;


public class NestedClass {
	
	static int s;
	
	int a;
	String b;
	List c;
	
	final List d =null;
	
	
	public static void main(String[] args) {
		NestedClass.StaticNested1 d = new StaticNested1();
		
		
	}
	
	
	
	
	protected class Nested1{
		
		private int a1;
		
		//static int s1;  //Error has inner classes cannot have static variables as they cannot exist on their own
		
		private void test(){
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(s);
			
			System.out.println(a1);
		}
		
		protected void wantToEnhanceit(){
			System.out.println("Basic version");
		}
	}
	
	
	public static  class StaticNested1{
		
		private int a1;
		
		static int s1;  //Error has inner classes cannot have static variables as they cannot exist on their own
		
		private void test(){
			
			//Cannot access instance variables of the enclosing class , but can access static variables
			/*			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			*/
			System.out.println(s);
			
			System.out.println(a1);
		}
	}
	
	
	
	private void testme(){
		int m1=0;
		
		//Cannot use any of the class modifiers , as they are invalid inside a method
		
		class LocalClass{
			
			private void localMethod(){
				
				//System.out.println(m1);  //can access only final variables of the enclosing method
				//but this is allowed in Java 8
				
				//but can access all instance variables of enclosing type
			}
		}
	}
	
	
	public interface TestInterface{
		
	}
	
	//Anonymous class
	//Same as inner Class
	private TestInterface  testInterface = new  TestInterface(){
		
		private void testMethod(){
			System.out.println(b);
			System.out.println(c);
		}
	};

}
