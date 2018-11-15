package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HomeWork1Client {

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		
		FileInputStream fis = new FileInputStream("A");
		ByteBuffer bb = ByteBuffer.allocate(1024);
		
		byte[] bs = new byte[1024];
		int len;
		while((len = fis.read(bs))!=-1) {
			bb.clear();
			bb.put(bs,0,len);
			bb.flip();
			sc.write(bb);
		}
		
		fis.close();
		sc.close();
	}

}
