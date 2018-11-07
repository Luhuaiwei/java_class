package excise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FileTest2 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		OutputStream fos ; 
		while(true) {
			fos = new FileOutputStream("E:\\java_class\\file\\out.txt",true);
			String line = scanner.nextLine();
			byte[] line_b = line.getBytes();
			fos.write(line_b);
			if("½áÊø".equals(line)) {
				break;
			}	
		}
		fos.close();
		scanner.close();

	}

}
