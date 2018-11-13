package excise;

public class MyThread extends Thread{
	private int num = 10;
	@Override
	public void run() {
		while(num>0) {
			System.out.println("thread");
			num--;
		}
	}

}
