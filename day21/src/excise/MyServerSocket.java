package excise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

	public static void main(String[] args) throws IOException {
		//10.31.165.28
		ServerSocket ss = new ServerSocket(8888);	
		Socket s ;
		while (true) {
			s = ss.accept();
			InputStream is = s.getInputStream();
			byte[] buf = new byte[1024];			
			int len ;
			while((len=is.read(buf))!=-1) {
				String text = new String(buf, 0, len);
				System.out.println(text);
			}
			
			OutputStream os = s.getOutputStream();
			os.write("数据已收到".getBytes());
			os.write(-1);
			
			
		}
		
	}

}
