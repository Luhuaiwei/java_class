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

		//gbk
/*		����: ���ĸ��߳�1��2��3��4��
		�߳�1�Ĺ��ܾ������1���߳�2�Ĺ��ܾ������2��
		�Դ�����.........
		�������ĸ��ļ�ABCD����ʼ��Ϊ�ա���Ҫ���ĸ��ļ������¸�ʽ��
		A��1 2 3 4 1 2....
		B��2 3 4 1 2 3....
		C��3 4 1 2 3 4....
		D��4 1 2 3 4 1....*/
		
		//˼·���ɹ��ɿ������߳�1��д��λ��Ҫô��A�ļ��ĵ�һ���ַ�
		//Ҫô��ǰ���Ȼ��4
		//���⼸���߳�Ҳͬ����ˣ��������˼·�������£�
		//1����ȡ�ļ����ж����ַ��ǲ��ǿ�
		//2�����ǿգ������judgeFirsr����д���Ӧ�̵߳��ַ�
		//3�������ǿգ������judge���������ݹ���д���ַ�
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
			loger.debug("judgeFirst��ȡ�ļ�"+address+"�Ƿ�Ϊ��:"+(line==null));
			if(line!=null) {
				String[] lines = line.split("");
				if(front.equals(lines[lines.length-1])) {
					loger.debug("����"+front+"���ļ�"+address);
					write(address);
				}
			}else {
				loger.debug("���ļ�"+address+"�м�������");
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
			loger.debug("judge��ȡ"+address+"�Ƿ�Ϊ��:"+(line==null));
			if(line!=null) {
				String[] lines = line.split("");
				if(front.equals(lines[lines.length-1])) {
					loger.debug("���뵽�ļ�"+address);
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
