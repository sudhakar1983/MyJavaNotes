package test;

import java.util.ArrayList;
import java.util.List;

public class A {


	public static void main(String[] args) {
		
		List<B> blist = new ArrayList<>();
		
		List<C> clist = new ArrayList<>();
		
		List <? extends B> extB = new ArrayList<>();
		
		
		
		List<? super B> supB = new ArrayList<A>();
		supB.add(new C());
		
		
		List<? super Integer> supInt = new ArrayList<>();
		
		test(extB);
		test(clist);
		
		
	}
	
	
	private static void test (List <? extends B> listB){
		
	}
	
}
