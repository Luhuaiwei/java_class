package homework;

public class HomeWork2 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					System.out.println("���߳�����");
				}
				//Class.class.notify();								
			}
			
		};
		Thread t1 = new Thread(r);
		t1.start();
		for (int i = 0; i < 50; i++) {	
			System.out.println("��"+i+"�ִ�ӡ");
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 100; j++) {
				System.out.println("���߳�����-");
			}
			if(i == 49) {}else {
				t1 = new Thread(r);
				t1.start();
			}
		}
		
		//�����߳���ʹ��wait�������̲߳��ܼ�ʱ�رյ�����
/*		for (int j = 0; j < 50; j++) {
			t1.start();
			synchronized (Class.class) {
				try {
					Class.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("���߳�����");
				}
			} 
		}
*/
	}

}
