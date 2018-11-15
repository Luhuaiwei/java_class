package excise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestDemo2 {

	public static void main(String[] args) throws IOException {
		//10.31.165.28
		DatagramSocket ds = new DatagramSocket(8000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		while(true) {
			ds.receive(dp);
			byte[] bt = dp.getData();
			int len = dp.getLength();
			//String name = ds.getInetAddress().getHostName();
			System.out.println(new String(bt,0,len));
		}
		
	}

}
