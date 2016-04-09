package Threads;
import java.util.concurrent.locks.ReentrantLock;


public class TestObj {
	
	private ReentrantLock rLock = new ReentrantLock();
	
	public TestObj(){
		
	}
	
	public static void printNum(){
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
//			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
