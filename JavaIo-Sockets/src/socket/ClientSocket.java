package socket;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
	public static void main(String[] args) throws  Exception {
		
		Socket s = new Socket("localhost", 79);
		OutputStream os = s.getOutputStream();
		

		
		PrintWriter pw = new PrintWriter(os);		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			
			System.out.println("Client received data ");
			String line = sc.nextLine();
			pw.print(line);
			pw.flush();
			if(line.equalsIgnoreCase("bye")){
				break;
			}
			
			
		}
		
		
		sc.close();pw.close();os.close();s.close();
		
	}

}
