package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class HomeWork3 {
	private static Logger loger = Logger.getLogger(HomeWork3.class);
	private static ThreadLocal<String> tl = new ThreadLocal<>(); 
	public static void main(String[] args) {
		
/*		需求: 有四个线程1、2、3、4。
		线程1的功能就是输出1，线程2的功能就是输出2，
		以此类推.........
		现在有四个文件ABCD。初始都为空。现要让四个文件呈如下格式：
		A：1 2 3 4 1 2....
		B：2 3 4 1 2 3....
		C：3 4 1 2 3 4....
		D：4 1 2 3 4 1....*/
		
		//思路：由规律看出，线程1所写的位置要么是A文件的第一个字符
		//要么其前面必然是4
		//另外几个线程也同理，因此，本题结题思路步骤如下：
		//1、读取文件，判断首字符是不是空
		//2、若是空，则调用judgeFirsr方法写入对应线程的字符
		//3、若不是空，则调用judge方法，依据规律写入字符
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				tl.set("1");
				while(true) {
					judgeFirst("A","4");
					judge("B","4");
					judge("C","4");
					judge("D","4");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				tl.set("2");
				while(true) {
					judgeFirst("B","1");
					judge("A","1");
					judge("C","1");
					judge("D","1");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				tl.set("3");
				while(true) {
					judgeFirst("C","2");
					judge("B","2");
					judge("A","2");
					judge("D","2");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				tl.set("4");
				while(true) {
					judgeFirst("D","3");
					judge("B","3");
					judge("C","3");
					judge("A","3");
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
		t3.start();
		t4.start();
	}
	protected static void judgeFirst(String address, String front) {		
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(address));	
			line = br.readLine();		
			loger.debug("judgeFirst读取文件"+address+"是否为空:"+(line==null));
			if(line!=null) {
				String[] lines = line.split("");
				if(front.equals(lines[lines.length-1])) {
					loger.debug("传入"+front+"到文件"+address);
					write(address);
				}
			}else {
				loger.debug("往文件"+address+"中加入首字");
				write(address);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
	protected static void judge(String address,String front) {
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(address));	
			line = br.readLine();		
			loger.debug("judge读取"+address+"是否为空:"+(line==null));
			if(line!=null) {
				String[] lines = line.split("");
				if(front.equals(lines[lines.length-1])) {
					loger.debug("传入到文件"+address);
					write(address);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	protected static void write(String filename) {	
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filename,true));
			bw.write(tl.get());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
