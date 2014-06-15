package socket;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class InetExample {
	public static void main(String[] args) throws Exception{
		
		Inet4Address inAdr = (Inet4Address) Inet4Address.getByName("localhost") ;
		System.out.println(inAdr);
		
		SocketAddress adr = new InetSocketAddress(inAdr, 79);
		java.net.ServerSocket serversoc = new java.net.ServerSocket();
		serversoc.bind(adr);
		
	}

}
