package excise;

public class TestDemo {
	public static int money =0 ; 
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				//father
				while(true) {
					synchronized(Class.class) {
						if(money<=0) {
							System.out.println("爸爸打了1000给儿子");
							money+=1000;
						}else {
							System.out.println("你不是还有钱吗？");
						}
						Class.class.notify();
						try {
							Class.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
						
				}
			}});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				//son
				while(true) {
					synchronized(Class.class) {
						if(money<=0) {
							System.out.println("爸我没钱了");
							Class.class.notify();
							try {
								Class.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("????");
						}else {
							System.out.println("儿子花了100");
							money-=100;
						}
						
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}

}
