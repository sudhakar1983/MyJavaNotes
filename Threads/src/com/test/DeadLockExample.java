package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeadLockExample{

	
	private static List<String> t = new ArrayList<String>();
	private static List<String> t2 = new ArrayList<String>();
	
	private static List<String> t3 = new ArrayList<String>();
	private static List<DeadLockExample> t4 = new ArrayList<DeadLockExample>();
	
	public static void main(String[] args) {
		
		
	/*	for(int i=0; i< 1000000 ; i++){
			//t3.add(new String(new Random(1000).toString()));
			t4.add(new DeadLockExample());
		}*/
		Thread.currentThread().setName("DeadLockExample");
		
		while (true){
			t3.add(new String(new Random(1000).toString()));
		}
		
		
		
/*		Runnable r = new  Runnable() {

			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				synchronized (t) {
					try {
						Thread.sleep(5000);
						
						synchronized (t2) {
							System.out.println(t2.size());
						}
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			};

			
			
			Runnable r2 = new  Runnable() {

				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					synchronized (t2) {
						try {
							Thread.sleep(5000);
							synchronized (t) {
								System.out.println(t.size());
							}
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					}
				};
				
				
				
			Thread t = new Thread(r);
			
			Thread t2 = new Thread(r2);
			t.start();t2.start();*/
	}
	
	

}
