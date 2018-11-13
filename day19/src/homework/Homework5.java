package homework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Homework5 {
	public static int num_producter = 0;
	public static int num_consumer = 0;
	public static Map<Integer,Goods>  map = null;
	public static void main(String[] args) {
		Factory fac = new Factory();
			
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				while(true) {
					synchronized (Class.class) {			
						// ������
						map = fac.getMap();
						if(map!=null) {	}else {
							map = new HashMap<>();
						}
						num_producter++;
						Goods goods = new Goods(num_producter,10.0,new Date());				
						map.put(num_producter, goods);	
						System.out.println(Thread.currentThread().getName() + "����һ����Ʒ");
						fac.setMap(map);						
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
					boolean b = false ; 
					synchronized (Class.class) {
						map = fac.getMap();
						Set<Integer> set = new HashSet<>();
						set = map.keySet();
						List<Integer> list = new ArrayList<>();	
						list.addAll(set);
						if (list.size()>0) {
							// ������				
							map.remove(list.get(0));
							System.out.println(Thread.currentThread().getName() + "����һ����Ʒ");
						}else {
							b = true;
						}					
					}
					if(b) {
						System.out.println("\t\t\t\t\t�������ѽ");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
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
		
		Thread t1 = new Thread(r1,"������1");
		Thread t2 = new Thread(r1,"������2");
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
