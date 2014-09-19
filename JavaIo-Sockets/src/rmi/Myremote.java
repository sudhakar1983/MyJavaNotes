package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Myremote extends Remote{

	public String say() throws RemoteException ;
	

}
