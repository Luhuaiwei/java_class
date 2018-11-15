package excise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MySocket2 {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("10.31.165.45",9999);
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		OutputStream os = socket.getOutputStream();
		os.write(line.getBytes());
		
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		byte[] buf = new byte[1024];			
		int len ;
		while((len=is.read(buf))!=-1) {
			String text = new String(buf, 0, len);
			System.out.println(text);
		}
		
		socket.close();
		

	}

}
