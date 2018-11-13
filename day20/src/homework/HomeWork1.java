package homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HomeWork1 {

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
					System.out.println("线程1执行");
					con2.signal();
					try {
						con1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.unlock();
				}
			
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					lock.lock();
					System.out.println("线程2执行");
					con3.signal();
					try {
						con2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.unlock();
				}
			}
			
		});
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					lock.lock();
					System.out.println("线程3执行");
					con1.signal();
					try {
						con3.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.unlock();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		
		//使用join方式的顺序执行
/*		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("线程1执行");
				}
			}});
		
		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					System.out.println("线程2执行");
				}
			}});
		
		Thread t3 = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					System.out.println("线程3执行");
				}
			}});
		
		t1.start();
		t2.start();
		t3.start();*/

	}

}
