import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortingProblems {

	public static void main(String[] args) {
		sortNames();
	}
	
	
	
	
	
	public static void sortNames(){
		String [][] s = new String [][]{{"a","d"}, {"a","b"}};
		
		
		
		Comparator<String []> c = new  Comparator<String[]>() {
			
			@Override
			public int compare(String[] o1, String[] o2) {
				
				int i = o1[1].compareTo(o2[1]) ;
				if(i == 0){
					i = o1[0].compareTo(o2[0]);
				}			
				
				return i;
			}
		};
		
		List<String[]> l = Arrays.asList(s);
		 Collections.sort(l, c);
		
		for(String[] a : l){
			System.out.println(a[0 ] + " " + a[1]);
		}
		
		
	}
}
