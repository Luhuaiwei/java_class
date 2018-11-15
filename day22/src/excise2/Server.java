package excise2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8888));
		ssc.configureBlocking(false);
		
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			if(selector.select()>0) {
				Set<SelectionKey> set = selector.selectedKeys();
				Iterator<SelectionKey> it = set.iterator();
				while(it.hasNext()) {
					SelectionKey key = it.next();
					if(key.isAcceptable()) {
						ServerSocketChannel ssc2 = (ServerSocketChannel) key.channel();
						SocketChannel sc = ssc2.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
						
						key.interestOps(SelectionKey.OP_ACCEPT);
						
					}else if(key.isReadable()){
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer bb = ByteBuffer.allocate(1024);
						
						bb.clear();
						sc.read(bb);
						System.out.println(new String(bb.array(),0,bb.position()));
						
						key.interestOps(SelectionKey.OP_READ);
					}
					
					it.remove();
				}
			}
		}
	}

}
