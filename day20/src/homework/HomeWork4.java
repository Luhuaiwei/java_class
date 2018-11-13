package homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class HomeWork4 {
	private static Logger loger = Logger.getLogger(HomeWork4.class);
	public static int num = 0;
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition con1 = lock.newCondition();
		Condition con2 = lock.newCondition();
		Condition con3 = lock.newCondition();
		//使用wait-notify方式的顺序执行
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					lock.lock();
					if (num<=70) {
						for (int i = 0; i < 5; i++) {
							num++;
							System.out.println(Thread.currentThread().getName() + "打印了" + num);
						}
						con2.signal();
						try {
							con1.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
						loger.debug("测试");
					}
					lock.unlock();
				}
			
			}
			
		},"线程1");
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					while (num==0) {
						Thread.yield();
					}
					lock.lock();					
					if (num<=70) {
						for (int i = 0; i < 5; i++) {
							num++;
							System.out.println(Thread.currentThread().getName() + "打印了" + num);
						}
						con3.signal();
						try {
							con2.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}
					lock.unlock();
				}
			}
			
		},"线程2");
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					while (num==0) {
						Thread.yield();
					}
					while (num==5) {
						Thread.yield();
					}
					lock.lock();				
					if (num<=70) {
						for (int i = 0; i < 5; i++) {
							num++;
							System.out.println(Thread.currentThread().getName() + "打印了" + num);
						}
						con1.signal();
						try {
							con3.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						} 
					}
					lock.unlock();
				}
			}
			
		},"线程3");
		
		
		t1.start();
		t2.start();
		t3.start();
		
/*		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					num++;
					System.out.println(Thread.currentThread().getName()+"打印了"+num);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(int i=0;i<5;i++) {
					num++;
					System.out.println(Thread.currentThread().getName()+"打印了"+num);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			}
		};
		Thread t2 = new Thread(r2);
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int j = 0; j < 5; j++) {
					try {
						t2.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 5; i++) {
						num++;
						System.out.println(Thread.currentThread().getName() + "打印了" + num);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Thread t2 = new Thread(r2,"Thread-1");	
					Thread t1 = new Thread(r1,"Thread-0");	
					t2.start();						
					t1.start();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();*/
		
	}
}