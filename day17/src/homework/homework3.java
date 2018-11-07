package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class homework3 {
	
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos1 = null;
		FileOutputStream fos2 = null;
		
		FileOutputStream fos = null;
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		
		byte[] buf = new byte[1024];
		int len =0;
		int end =0;
		try {
			//²ð²ð²ð²ð²ð²ð²ð²ð
			File fls = new File("E:\\java_class\\file\\×íÃÎÇ°³¾.mp3");
			fis = new FileInputStream(fls);
			fos1 = new FileOutputStream("E:\\java_class\\file\\×íÃÎÇ°³¾\\1.mp3");
			fos2 = new FileOutputStream("E:\\java_class\\file\\×íÃÎÇ°³¾\\2.mp3");
			while((end = fis.read(buf)) != -1) {
				len+=end;
				if(len<fls.length()/2) {
					fos1.write(buf, 0, end);
				}else {
					fos2.write(buf, 0, end);
				}
				//fos2.write(buf, 0, end);
			}
			//ºÏºÏºÏºÏºÏºÏºÏºÏ
			fis1 = new FileInputStream("E:\\java_class\\file\\×íÃÎÇ°³¾\\1.mp3");
			fis2 = new FileInputStream("E:\\java_class\\file\\×íÃÎÇ°³¾\\2.mp3");
			fos = new FileOutputStream("E:\\java_class\\file\\×íÃÎÇ°³¾\\ºÏ\\×íÃÎÇ°³¾.mp3",true);
			while((end = fis1.read(buf)) != -1) {
				fos.write(buf, 0, end);
			}
			while((end = fis2.read(buf)) != -1) {
				fos.write(buf, 0, end);
			}
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {				
					fis.close();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos1!=null) {
				try {
						fos1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos2!=null) {
				try {
						fos2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
