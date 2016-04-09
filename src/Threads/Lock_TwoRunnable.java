package Threads;
import java.util.concurrent.locks.ReentrantLock;


public class Lock_TwoRunnable implements Runnable {

	private int count = 100;//多个线程中共用count，保证安全，
//	对count进行操作时需要加锁（synchronized或者给runnable类加一个lock对象）.这个锁一定要是runnable类的属性或者使用对象的一个属性，不能是定义在一个方法中作为局部变量
	private ReentrantLock lock = new ReentrantLock();
	private Object x = new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//			TestObj.printNum();
			while(true){
				lock.lock();
//				synchronized (x) {
					
				
				try {
				if (count > 0) {
					Thread.sleep(200);
					count--;
					System.out.println(Thread.currentThread().getName() + "------" +count);
				}
				else {
					break;
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			lock.unlock();
			}
//			}
			}
	}
	
	public static void main(String[] args) {
		
		Lock_TwoRunnable runnable = new Lock_TwoRunnable();
		
		Thread t1 = new Thread(runnable,"t1");
		Thread t2 = new Thread(runnable,"t2");
		Thread t3 = new Thread(runnable,"t3");
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
