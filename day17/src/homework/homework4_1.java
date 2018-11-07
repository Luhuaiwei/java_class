package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class homework4_1 {

	public static void main(String[] args) {
		//E:\java_class
		File file = new File("E:\\java_class\\file");
		File file_new = new File("E:\\java_class\\file-副本");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		file_new.mkdir();
		try {
			getFile(file,file_new,fis,fos);
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
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static void getFile(File file, File newdir, FileInputStream fis, FileOutputStream fos) throws IOException {
		String[] s ;
		s = file.list();
		for (int i = 0; i < s.length; i++) {
			File temp = new File(file,s[i]);
			int len = 0;
			byte[] buf = new byte[1024];
			if(temp.isFile()) {
				File temp_file = new File(newdir,s[i].substring(0, s[i].length()-4)+"-副本.txt");
				System.out.println(temp_file.getAbsolutePath());
				boolean b = temp_file.createNewFile();
				System.out.println(b);
				fis = new FileInputStream(temp);
				fos = new FileOutputStream(temp_file);			
				while((len = fis.read(buf))!=-1) {
					
					fos.write(buf, 0, len);
				}
			}else {
				File temp_dir = new File(newdir,s[i]+"-副本");
				temp_dir.mkdir();
				System.out.println(temp_dir.getName());
				System.out.println(temp_dir.getAbsolutePath());
				getFile(temp,temp_dir,fis,fos);
			}
			
		}
		
	}

}
