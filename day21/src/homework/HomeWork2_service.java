package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork2_service {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		while(true) {
			Socket s = ss.accept();
			new Thread() {
				@Override
				public void run() {							
					try {					 	
						OutputStream os = s.getOutputStream();
						InputStream is = s.getInputStream();
						byte[] buf = new byte[1024];			
						int len ;
						//获取地址
						len = is.read(buf);
						String path = new String(buf,0,len);
						System.out.println("获得地址："+path);
						//根据地址下载文件
						CopyFile(path);
		
											
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if(s!=null) {
							try {
								s.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
				}

				private void CopyFile(String path) {
					// TODO Auto-generated method stub
					
				}
			}.start();
		}
	}

}
