package homework;

public class Homework3 {

	public static void main(String[] args) {
		Thread t1 = new Thread( new Runnable() {

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
		t3.start();
		
	}

}
