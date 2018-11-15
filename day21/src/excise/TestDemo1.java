package excise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TestDemo1 {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket();
		
		
		DatagramPacket dp = new DatagramPacket(new byte[10], 10,InetAddress.getByName("10.31.165.45"),8888);
		Scanner sc = new Scanner(System.in);
		while(true) {
			String line = sc.nextLine();
			if("ÍË³ö".equals(line)) {
				break;
			}
			dp.setData(line.getBytes());
			dp.setLength(line.getBytes().length);
			ds.send(dp);
			
		}
		sc.close();
		ds.close();
		
		
	}

}
