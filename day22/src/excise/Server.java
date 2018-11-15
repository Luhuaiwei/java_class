package excise;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8888));
		SocketChannel sc = ssc.accept();
		
		ByteBuffer bb = ByteBuffer.allocate(1024);
		//bb.flip();
		bb.clear();
		sc.read(bb);
		System.out.println(new String(bb.array(),0,bb.position()));
		
		
		//bb.flip();
		bb.clear();
		bb.put("服务器收到请求".getBytes());
		//System.out.println(new String(bb.array(),0,bb.position()));
		bb.flip();
		sc.write(bb);
		sc.close();
		ssc.close();
	}

	
	

}
