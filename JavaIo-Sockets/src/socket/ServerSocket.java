package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocket {

	public static void main(String[] args) throws Exception {
	
		java.net.ServerSocket serversoc = new java.net.ServerSocket(79);
		
		Socket  clientSocket =   serversoc.accept();
		System.out.println("Server Started !");
		
/*		OutputStream os = clientSocket.getOutputStream();
		
		BufferedWriter bw = new BufferedWriter(new PrintWriter(os));
		bw.write("Received");*/
		
		InputStream is = clientSocket.getInputStream();		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		Scanner sc = new Scanner(is);		
		while(sc.hasNext()){			
			
			String line = sc.nextLine();
		
			if(line.equalsIgnoreCase("disconnect")){
				break;
			}
			System.out.println(line);	
		}		
		
		
/*		
		
		System.out.println("Server started !");
		String line = null;
		while(( line = br.readLine()) != null){
			
			if("disconnect".equalsIgnoreCase(line)){
				break;
			}
			
			System.out.println(line);
		}*/
		
		clientSocket.close();serversoc.close();
		
	}
}
