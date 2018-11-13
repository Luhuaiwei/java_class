package homework;

import java.io.FileWriter;
import java.io.IOException;

public class ClearABCD {

	public static void main(String[] args) throws IOException {
		FileWriter fw1 = new FileWriter("A");
		FileWriter fw2 = new FileWriter("B");
		FileWriter fw3 = new FileWriter("C");
		FileWriter fw4 = new FileWriter("D");
		
		fw1.close();
		fw2.close();
		fw3.close();
		fw4.close();
	}

}
