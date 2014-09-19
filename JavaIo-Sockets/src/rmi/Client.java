package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) {

		
	}

	private static void usingRMIRegistry(){
		 try {
	            Registry registry = LocateRegistry.getRegistry("localhost",1120);
	            Myremote stub = (Myremote) registry.lookup("hello");
	            String response = stub.say();
	            System.out.println("response: " + response);
	        } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	        }
	}
	
	private static void usingNaminContext(){
	
		try {
			
			
			Hashtable env = new Hashtable();
			//env.put(Context.PROVIDER_URL, "ldap://ldap.wiz.com:389");
			Context ctx = new InitialContext();
			Myremote r = (Myremote) ctx.lookup("hello");
			System.out.println(r.say());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
