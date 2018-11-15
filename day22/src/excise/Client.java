package excise;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("127.0.0.1",8888));
		
		ByteBuffer bb = ByteBuffer.allocate(1024);
		//sc读，对于缓冲区来说就是输入，也就是put数据到缓冲区===> read = put clear
		//sc写，对于缓冲区来说就是输出，也就是get缓冲区的数据===> writer = get flip
		//bb.clear();
		//bb.flip();
		bb.put("请求连接服务器".getBytes());
		
		bb.flip();
		sc.write(bb);
		
		bb.clear();
		sc.read(bb);
		System.out.println(new String(bb.array(),0,bb.position()));
		sc.close();
	}

}
