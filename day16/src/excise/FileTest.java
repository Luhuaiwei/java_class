package excise;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
/*		File file = new File("d:\\test1\\demo");
		boolean b = file.mkdir();
		System.out.println(b);*/
		File file = new File("d:\\personalfilms");
		File file2 = new File("d:\\TokyoHot.txt");
		boolean b1= file.mkdir();
		
		boolean b2 = file.renameTo(file2);
		
		boolean b3 = file2.delete();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
	
	
		
	}

}
