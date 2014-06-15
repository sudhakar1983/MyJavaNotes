package socket;

import java.util.Scanner;

public class Scan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		
	
		while(sc.hasNext()){
			String line = sc.nextLine();
			
			if("bye".equalsIgnoreCase(line)) break;
			sb.append(line);		
			
		}
		System.out.println(sb);
		
		sc.close();
	}
}
