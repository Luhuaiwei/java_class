package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HomeWork2_client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",8888);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		//获取地址
		Scanner scan = new Scanner(System.in);
		String path = scan.nextLine();
		//写入地址到服务器
		os.write(path.getBytes());
		
		socket.close();

	}

}
