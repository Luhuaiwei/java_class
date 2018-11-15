package homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class HomeWork1_client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1",9999);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();	
		byte[] buf = new byte[1024];			
		int len ;
		
		//获取文件列表
		System.out.println("文件列表如下：");
		int list_len;
		list_len = is.read();
		System.out.println("-----\r\n");
		for (int i = 0; i < list_len; i++) {
			len=is.read(buf);
			System.out.println(new String(buf,0,len));
		}
		//输入所要下载的文件名
		System.out.println("请输入所要下载的文件");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		//将所要下载的文件名上传到服务器
		os.write(line.getBytes());
		//接收文件
		FileOutputStream fos = new FileOutputStream(".\\service\\d.mp3");
		while((len=is.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		socket.close();
	}

}
