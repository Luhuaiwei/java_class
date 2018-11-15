package excise;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MySocket {

	public static void main(String[] args) throws IOException {
		//Socket socket = new Socket("10.31.165.45",8888);
		Socket socket = new Socket("10.31.165.28",8888);
		Scanner scan = new Scanner(System.in);
		while (true) {
			String line = scan.nextLine();
			OutputStream os = socket.getOutputStream();
			os.write(line.getBytes());
			
			
		}
		
	}

}
