package excise;

public class Demo1 {

	public static void main(String[] args) {
/*		MyThread thread1 = new MyThread();
		thread1.start();
		MyThread thread2 = new MyThread();
		thread2.start();
		
		Thread thread3 = new Thread(new MyRunnable());
		thread3.start();
		Thread thread4 = new Thread(new MyRunnable());
		thread4.start();*/
		
/*		Thread thread5 = new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name);
				Thread.currentThread().setName("Àî¹·µ°");
				name = Thread.currentThread().getName();
				System.out.println(name);
				
			}});
		thread5.start();*/
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name);
				Thread.currentThread().setName("Àî¹·µ°");
				name = Thread.currentThread().getName();
				System.out.println(name);
				
			}}).start();
			
	}

}
