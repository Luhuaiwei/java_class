package homework;

public class Homework4 {
	private static int baozi = 0;
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while(true) {
					synchronized (obj1) {
						if (baozi < 100) {
							// 做包子
							System.out.println(Thread.currentThread().getName() + "做了一个包子");
							baozi++;
							System.out.println("\t\t\t现在有" + baozi + "个包子");
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				}
				
			}
			
		};
		
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				while(true) {
					synchronized (obj2) {
						if (baozi > 0 ) {
							// 吃包子
							System.out.println(Thread.currentThread().getName() + "吃了一个包子");
							baozi--;
							System.out.println("\t\t\t现在有" + baozi + "个包子");
						}else {
							System.out.println("\t\t\t\t\t尼玛上包子啊");
						}
						
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		};
		
		Thread t1 = new Thread(r1,"包子员工1");
		Thread t2 = new Thread(r1,"包子员工2");
		Thread g1 = new Thread(r2,"顾客1");
		Thread g2 = new Thread(r2,"顾客2");
		Thread g3 = new Thread(r2,"顾客3");
		
		t1.start();
		t2.start();
		g1.start();
		g2.start();
		g3.start();
	}

}
