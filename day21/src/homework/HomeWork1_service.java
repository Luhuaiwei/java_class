package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork1_service {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9999);		
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
						//获取文件列表
						File file = new File(".\\service");
						String[] filenames = file.list();
						//将文件列表输出到客户端
						os.write(filenames.length);
						for (int i = 0; i < filenames.length; i++) {
							os.write((filenames[i]+"\r\n------\r\n").getBytes());
							System.out.println(filenames[i]);
						}
						//获取用户所要下载的文件名
						Thread.sleep(100);
						len = is.read(buf);
						String filename = new String(buf,0,len);
						System.out.println("获得文件名："+filename);
						//根据用户名下载文件
						for(String temp : filenames) {
							if(filename.equals(temp)) {
								FileInputStream fis = new FileInputStream(".\\service\\"+filename);
								while((len=fis.read(buf))!=-1) {
									os.write(buf,0,len);
								}	
							}
						}
											
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
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
			}.start();
		}	

	}

}
