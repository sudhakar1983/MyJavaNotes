import java.util.ArrayList;
import java.util.List;

import test.B;
import test.A;


public class AssignmentTests {

	public static void main(String[] args) {
		
		//List<Object>  objectList = new ArrayList<A>(); //Will not compile Type mismatch
		
		List<A>  alist = new ArrayList<A>();		
		
		//alist = new ArrayList<B>();	//will not compile	type mismatch
		
		
		
		//Extends Assignment
		List<? extends String> strList1 = new ArrayList<String>();
		strList1.add(new String());	//will not compile
		strList1.add(new Object());	//will not compile
		
		
		List<? extends Object> objList1 = new ArrayList<Object>();
		objList1.add(new String());	//will not compile
		objList1.add(new Object());	//will not compile		
		
		List<? extends A> aObjList1 = new ArrayList<A>();
		objList1.add(new B());	//will not compile
		objList1.add(new A());	//will not compile	
		
		
		strList1 = new ArrayList<String>();
		strList1 = new ArrayList<Object>();		
		objList1 = new ArrayList<String>();
		aObjList1 = new ArrayList<B>();
		
		
		//Super Assignment & Additions
		List<? super String> strSuperList1 = new ArrayList<String>();
		strSuperList1.add(new String());	
		strSuperList1.add(new Object());	//will not compile   - Only String 		
		
		List<? super A> aObjSuperList1 = new ArrayList<A>();
		aObjSuperList1.add(new B());	
		aObjSuperList1.add(new A());		// Anything that can be type casted to A except Object 
		
		
		
		List<? super B> aObjSuperList2 = new ArrayList<B>();
		aObjSuperList1.add(new B());	//
		aObjSuperList1.add(new A());	// Anything type casted to B or Parent of B  except Object
		aObjSuperList1.add(new Object());
		
		
		String[] arr = {"a","b"};		
		Object[] oArr = arr;	//Will compile 
		
		
		
	}
	
}
