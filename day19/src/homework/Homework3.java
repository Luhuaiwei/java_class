package homework;

public class Homework3 {

	public static void main(String[] args) {
		Thread t1 = new Thread( new Runnable() {

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
		t3.start();
		
	}

}
