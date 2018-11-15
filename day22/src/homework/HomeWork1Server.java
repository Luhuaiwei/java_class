package homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class HomeWork1Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8888));
		
		SocketChannel sc = ssc.accept();
		FileOutputStream fos = new FileOutputStream("B");
		ByteBuffer bb = ByteBuffer.allocate(1024);
		int len;
		while(true) {
			bb.clear();
			len = sc.read(bb);
			if(len==-1) {
				break;
			}
			fos.write(bb.array(),0,len);
			
		}
		fos.close();
		sc.close();
		ssc.close();
	}

}
