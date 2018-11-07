package excise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileTest {

	public static void main(String[] args) throws IOException {
		InputStream fis =new FileInputStream("E:\\java_class\\file\\abc\\aaa.txt");
		OutputStream fos = new FileOutputStream("E:\\java_class\\file\\abc\\bbb.txt");
		/*		int i;
		while((i=fis.read())!=-1) {
			System.out.print((char)i);
		}*/
		
		byte[] b = new byte[1024];
		int i;
		while((i=fis.read(b))!=-1) {
			fos.write(b, 0, i);
		}
		
		
		fis.close();
		fos.close();

	}

}
