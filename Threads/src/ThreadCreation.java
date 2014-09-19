import java.util.Stack;

public class ThreadCreation {

	public static void main(String[] args) {
		MyCollection coll = new MyCollection();
		coll.kill = false;

		RemoveCollClass t2 = new RemoveCollClass();
		t2.setName("Thread2");
		t2.coll = coll;
		t2.start();

		AddCollClass t1 = new AddCollClass();
		t1.setName("Thread1");
		t1.coll = coll;
		t1.start();

		RemoveCollClass t3 = new RemoveCollClass();
		t3.setName("Thread3");
		t3.coll = coll;
		t3.start();
		
	

		try {
			Thread.sleep(5000);
			t1.interrupt();
			Thread.sleep(5000);
			
			t3.interrupt();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		coll.kill = true;
	}

	static class RemoveCollClass extends Thread {

		volatile MyCollection coll;
		int count = 0;

		@Override
		public void run() {
			// System.out.println("ThreadClass is running ");

			while (!coll.kill) {
				System.out.println(Thread.currentThread().getName()
						+ " -->RemoveCollClass Attempt -->" + count);
				try {
					coll.remove();
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " Interrupted ... retrying ...."+Thread.interrupted());
					continue;
				}
				count++;
				if(Thread.interrupted()){
					System.out.println(Thread.currentThread().getName() +" gracefully shutting down ");
					return;
				}

			}
			System.out.println(Thread.currentThread().getName() +" killed ");
		}
	}


	static class AddCollClass extends Thread {

		volatile MyCollection coll;
		int count = 0;

		@Override
		public void run() {

			while (!coll.kill) {


				try {
					coll.add();
					count++;
					Thread.sleep(4000);//do some operation					
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " Interrupted ... retrying ...."+Thread.interrupted());
					continue;
				}
				
				System.out.println(Thread.currentThread().getName()
						+ " --> AddCollClass Attempt -->" + count);	
				if(Thread.interrupted()){
					System.out.println(Thread.currentThread().getName() +" gracefully shutting down ");
					return;
				}

			}
			
			System.out.println(Thread.currentThread().getName() +" killed ");
		}
	}

	static class MyCollection {
		Stack<String> container = new Stack<String>();

		int maxSize = 5;
		volatile boolean kill = false;

		public synchronized boolean isFull() {
			if (container.size() >= maxSize)
				return true;
			else
				return false;
		}

		public synchronized boolean isEmpty() {
			if (container.size() <= 0)
				return true;
			else
				return false;
		}

		public synchronized void add() throws InterruptedException {

			if (isFull()) {
				try {
					System.out.println(Thread.currentThread().getName() + " wait triggered on-->");
					wait(2000);
				} catch (InterruptedException e) {
					throw e;
				}
			}
			if (!isFull()) {
				container.add(Thread.currentThread().getName());
				System.out.println(" Add Completed by "
						+ Thread.currentThread().getName());
				notifyAll();
			}
			
			if(Thread.currentThread().isInterrupted()){				
				// returning to shutdown
				return;
			}


		}

		public synchronized void remove() throws InterruptedException{

			if (isEmpty()) {
				try {
					System.out.println(Thread.currentThread().getName() + " wait triggered on-->");
					wait(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block					
					throw e;
				}
			}
			if (!isEmpty()) {
				container.pop();
				System.out.println(" Remove Completed by "
						+ Thread.currentThread().getName());
			}
			
			
			if(Thread.currentThread().isInterrupted()){				
				// returning to shutdown
				return;
			}


		}
	}

	static class RunnableClass implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

}
