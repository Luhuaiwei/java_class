package excise3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Server {
	
	private static Selector clientSends ;
	private static Selector clientReceives;
	private static HashMap<String, String> names = new HashMap<>();
	private static ByteBuffer bb = ByteBuffer.allocate(1024);
	private static ServerSocketChannel ssc = null;
	public static void main(String[] args) {
		
		//一个的用户的发送端和接收端  	ip	
		//客户端的发送端 4444
		//客户端的接收端 6666
		//提醒用户, 把用户发送的第一句话当作用户名
		
		try {
			clientSends = Selector.open();
			clientReceives = Selector.open();
			
			//获取服务端通道
			ssc = ServerSocketChannel.open();
			//绑定端口号
			ssc.socket().bind(new InetSocketAddress(8888));
			//设置服务端通道为非阻塞
			ssc.configureBlocking(false);
			//将服务端通道加入到通道管理器中,检测是否有新连接进来这个状态
			ssc.register(clientSends,SelectionKey.OP_ACCEPT);
			//不停的查看通道管理器,看看有没有需要处理的通道
			while(true){
				//遍历所有的发送端通道 (这里面有服务端通道)
				//将所有已经准备好的通道单独存放,返回一个数量
				if(clientSends.select()>0){
					//获取单独存放的所有已经准备好的通道
					Set<SelectionKey> set = clientSends.selectedKeys();
					
					//遍历所有通道,对每个通道进行处理
					Iterator<SelectionKey> it = set.iterator();
					
					while(it.hasNext()){
						SelectionKey key = it.next();
						//处理通道
						dealChannel(key);
						//将已经处理好的通道,从已经准备好这个区域移出出去
						it.remove();
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//处理已经准备好的通道
	public static void dealChannel(SelectionKey key){
		try {
			//处理新的客户单连接, 如果是客户端发送端,放入到发送端的通道管理器中
			//如果是客户端接收,放入到接受端的通道管理器中
			if(key.isAcceptable()){
				//将通道管理其中存放的SelectionKey强转成ServerSocketChannel
				ServerSocketChannel ssc2 = (ServerSocketChannel)key.channel();
					//获取新的客户端连接
					SocketChannel sc = ssc.accept();
					//将新的连接设置成非阻塞
					sc.configureBlocking(false);
					//获取新连接的ip地址和端口号
					String ipPort = sc.getRemoteAddress().toString();
					String[] ipAndPort = ipPort.split(":");
					
					//判断是否是发送端
					if("4444".equals(ipAndPort[1])){
						System.out.println("有新的客户端发送端连接进来");
						//判断用户是否已经注册过了
						if(names.containsKey(ipAndPort[0])){
							//发送欢迎回来的欢迎语
							sendMessage("欢迎回来", ipAndPort[0]);
						}else{
							//如果没有注册过的话,提醒用户注册
							sendMessage("欢迎来到千锋群聊,请现注册一个昵称,请注意,您发送的第一句话会当作您的昵称,请慎重", ipAndPort[0]);
						}
						//将通道存入到客户端发送端的通道管理器中,设置状态为读
						sc.register(clientSends, SelectionKey.OP_READ);
						
						//判断是否是接收端
					}else if("6666".equals(ipAndPort[1])){
						System.out.println("有新的客户端接收端连接进来");
						//将通道存入到客户端接收端的通道管理器中,设置状态为写
						sc.register(clientReceives,SelectionKey.OP_WRITE);
					}else{
						sc.close();
					}
					//重置当前通道的检测状态
					key.interestOps(SelectionKey.OP_ACCEPT);
				//如果是客户端发送过来的数据, 接收数据,并将数据发送给所有的客户端接收端
			}else if(key.isReadable()){
				//将SelectionKey中获取到的通道强转成SocketChannel
				SocketChannel sc = (SocketChannel) key.channel();
				//接收组装客户端传递过来的数据
				bb.clear();
				sc.read(bb);
				String str = new String(bb.array(),0,bb.position());
				//获取客户端的ip地址和端口号,以便于比对
				String ipPort = sc.getRemoteAddress().toString();
				String[] ipAndPort = ipPort.split(":");
				//如果已经注册了,就将信息发送给所有人
				if(names.containsKey(ipAndPort[0])){
					str =  names.get(ipAndPort[0])+" : " +str;
					sendMessage(str, "");
					//如果是第一次注册,获取昵称,存入集合,通知所有人
				}else{
					//如果已经存在了,那么,就让他重新输入
					if(names.values().contains(str)){
						sendMessage("昵称已经存在,请重新输入",ipAndPort[0]);
						//否则就将信息发送给所有的人
					}else{
						names.put(ipAndPort[0], str);
						str = "欢迎"+str+"加入千锋群聊大家庭,大家鼓掌欢迎!!!!";
						sendMessage(str,"");
					}
				}
				System.out.println(str);
				//重置当前通道的检测状态,设置为读
				key.interestOps(SelectionKey.OP_READ);
			}
		} catch (IOException e) {
			//将SelectionKey销毁
			key.cancel();
			System.out.println("断开.....");
		}
	}
	/**
	 * 
	 * @param mesage
	 * @param ip 如果ip是空字符串,那么我们认为发送给所有人
	 * 			  如果ip不是空字符串,那么我们认为发送给某个人
	 */		
	public static void sendMessage(String mesage,String ip){
		//设置一个表示,如果在发送给某个人的情况下,从通道中找到了这个人,那么,我们就停止循环
		boolean flg = false;
		try {
			//遍历客户端接收端通道
			if(clientReceives.select()>0){
				//获取所有已经准备好的通道
				Set<SelectionKey> set = clientReceives.selectedKeys();
				
				//遍历通道
				Iterator<SelectionKey> it = set.iterator();
				
				while(it.hasNext()){
					SelectionKey key = it.next();
					try{
						//将通道强转成SocketChannel
						SocketChannel sc = (SocketChannel)key.channel();
						//获取当前听到的ip地址和端口号
						String ipPort = sc.getRemoteAddress().toString();
						String ip1 = ipPort.substring(0,ipPort.lastIndexOf(":"));
						
						bb.clear();
						bb.put(mesage.getBytes());
						
						bb.flip();
						//如果传递过来的ip地址是空字符串
						if(ip.isEmpty()){
							//发送信息给所有人
							sc.write(bb);
						}else{
							//否则,判断接收端通道管理器中是否有对应ip的通道,如果有,发送信息
							if(ip1.equals(ip)){
								sc.write(bb);
								flg = true;
							}
						}
						//
						it.remove();
						key.interestOps(SelectionKey.OP_WRITE);
						
						/*if(flg){
							//将剩余的所有已经准备好的通道都移出已经准备区域
							set.clear();
							break;
						}*/
					}catch(Exception e){
						key.cancel();
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
