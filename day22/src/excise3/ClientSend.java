package excise3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientSend {

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.socket().bind(new InetSocketAddress(4444));
//		sc.connect(new InetSocketAddress("10.31.165.45", 8888));
		sc.connect(new InetSocketAddress("127.0.0.1", 8888));
		Scanner scanner = new Scanner(System.in);
		ByteBuffer bb = ByteBuffer.allocate(1024);
		while(true) {
			String str = scanner.next();
			bb.clear();
			bb.put(str.getBytes());
			bb.flip();
			sc.write(bb);
		}

	}

}
