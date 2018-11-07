package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class homework4_2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File file = new File("F:\\纪录片\\DiQiuMaiDong\\[行星地球05].mkv");
		//F:\纪录片\DiQiuMaiDong\[行星地球05].mkv
		//E:\java_class\file\视频操作.mp4
		try {
			
			fis = new FileInputStream(file);
			
			fos = new FileOutputStream("E:\\java_class\\file\\视频操作.mp4");
			int len = 0;
			double sum = 0.0;
			double count = 0.0;
			byte[] buf = new byte[1024];
			while((len=fis.read(buf))!=-1) {
				sum = sum +len;
				count = (sum*100)/file.length();
				fos.write(buf, 0, len);
				System.out.println("已拷贝"+count+"%");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		

	}

}
