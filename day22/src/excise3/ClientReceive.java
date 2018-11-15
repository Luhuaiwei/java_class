package excise3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientReceive {

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.socket().bind(new InetSocketAddress(6666));
//		sc.connect(new InetSocketAddress("10.31.165.45", 8888));
		sc.connect(new InetSocketAddress("127.0.0.1", 8888));
		ByteBuffer bb = ByteBuffer.allocate(1024);
		while(true) {
			bb.clear();
			sc.read(bb);
			System.out.println(new String(bb.array(),0,bb.position()));
		}

	}
	

}
