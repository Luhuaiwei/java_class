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
		//ʹ��wait-notify��ʽ��˳��ִ��
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					lock.lock();
					System.out.println("�߳�1ִ��");
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
					System.out.println("�߳�2ִ��");
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
					System.out.println("�߳�3ִ��");
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
		
		
		//ʹ��join��ʽ��˳��ִ��
/*		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("�߳�1ִ��");
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
					System.out.println("�߳�2ִ��");
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
					System.out.println("�߳�3ִ��");
				}
			}});
		
		t1.start();
		t2.start();
		t3.start();*/

	}

}
