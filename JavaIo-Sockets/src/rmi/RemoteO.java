package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.omg.CosNaming.NamingContext;

public class RemoteO 
extends UnicastRemoteObject  
implements Myremote{
	

	protected RemoteO() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String say() throws RemoteException {
		// TODO Auto-generated method stub
		return "hi";
	}
	
	public static void main(String[] args) throws RemoteException{

		
		usingNaminContext();
		
	}
	
	
	
	private static void usingRMIRegistry(){
		 try {
				
				RemoteO r = new RemoteO();
				Myremote stub =  (Myremote) UnicastRemoteObject.exportObject(r,1120);		
				Registry reg = LocateRegistry.createRegistry(1120);
				reg.rebind("hello", stub);
	        } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	        }
	}
	
	/***
	 * This only works within the J2ee container
	 */
	
	private static void usingNaminContext() {
		try {
			RemoteO r = new RemoteO();
			
			Hashtable env = new Hashtable();
			
			//env.put(Context.PROVIDER_URL, "ldap://ldap.wiz.com:389");
			Context ctx = new InitialContext();
			
			ctx.bind("hello", r);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
