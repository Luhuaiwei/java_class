package homework;

public class Homework2 {
	public static void main(String[] args) {
		Thread hanhong = new Thread(new Runnable() {
	
			@Override
			public void run() {
				System.out.println("º«ºì¿ªÊ¼³ª¸è");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("°é×à½áÊø");		
			}});
		Runnable r = new Runnable() {
	
			@Override
			public void run() {
				while(true) {	
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"°éÎèÖĞ");
				}
			}
		};
		
		Thread t1 = new Thread(r,"°éÎèÑİÔ±1");
		Thread t2 = new Thread(r,"°éÎèÑİÔ±2");
		Thread t3 = new Thread(r,"°éÎèÑİÔ±3");
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		hanhong.start();
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}
