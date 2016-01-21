import java.util.ArrayList;
import java.util.List;

import test.A;
import test.B;


public class ExtendsTest {

	public static void main(String[] args) {
		
		List<Object> oList = new ArrayList<Object>();
		testPassing(oList);
		

		//Extends Assignment
		List<? extends String> strList1 = new ArrayList<String>();
		testPassing(strList1);
		testExtendingObject(strList1);
		testExtendingStr(strList1);
		
		
		
		List<? extends Object> objList1 = new ArrayList<Object>();
		testExtendingObject(objList1);
		testExtendingStr(objList1);
		
		
		List<? extends B> aObjList1 = new ArrayList<B>();
		testExtendingObject(aObjList1);
		testExtendingObject(new ArrayList<B>());
		testExtendingB(aObjList1);
		
		
	}
	
	
	private static void testPassing(List<Object> listObject){
		
	}
	
	private static void testExtendingObject(List<? extends Object> listObject){
		
	}
	
	private static void testExtendingStr(List<? extends String> listObject){
		
	}
	
	
	private static void testExtendingB(List<? extends A> listObject){
		
	}
}
