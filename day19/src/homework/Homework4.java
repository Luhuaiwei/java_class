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
							// ������
							System.out.println(Thread.currentThread().getName() + "����һ������");
							baozi++;
							System.out.println("\t\t\t������" + baozi + "������");
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
							// �԰���
							System.out.println(Thread.currentThread().getName() + "����һ������");
							baozi--;
							System.out.println("\t\t\t������" + baozi + "������");
						}else {
							System.out.println("\t\t\t\t\t�����ϰ��Ӱ�");
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
		
		Thread t1 = new Thread(r1,"����Ա��1");
		Thread t2 = new Thread(r1,"����Ա��2");
		Thread g1 = new Thread(r2,"�˿�1");
		Thread g2 = new Thread(r2,"�˿�2");
		Thread g3 = new Thread(r2,"�˿�3");
		
		t1.start();
		t2.start();
		g1.start();
		g2.start();
		g3.start();
	}

}
