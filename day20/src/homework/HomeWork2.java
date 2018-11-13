package homework;

public class HomeWork2 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					System.out.println("子线程运行");
				}
				//Class.class.notify();								
			}
			
		};
		Thread t1 = new Thread(r);
		t1.start();
		for (int i = 0; i < 50; i++) {	
			System.out.println("第"+i+"轮打印");
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 100; j++) {
				System.out.println("主线程运行-");
			}
			if(i == 49) {}else {
				t1 = new Thread(r);
				t1.start();
			}
		}
		
		//在主线程中使用wait遇到子线程不能及时关闭的问题
/*		for (int j = 0; j < 50; j++) {
			t1.start();
			synchronized (Class.class) {
				try {
					Class.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("主线程运行");
				}
			} 
		}
*/
	}

}
