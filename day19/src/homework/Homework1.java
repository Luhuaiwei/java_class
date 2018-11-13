package homework;

public class Homework1 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
		
				System.out.println("给老婆吃一口");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
			
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("给老公吃一口");
					try {
						t1.join(10);
						Thread t1 = new Thread(r);
						t1.start();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				
				
			}
			
		});
		t1.start();
		t2.start();
		
		

		
	}

}
