package homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class homework2 {

	public static void main(String[] args) {
		System.out.println("��ӭ����ע�����");
		Scanner scanner = new Scanner(System.in);
		OutputStream fot = null;
		try {
			System.out.print("�������û�����");
			String line = scanner.nextLine();
			line = line + "=";
			byte[] b = line.getBytes();
			fot = new FileOutputStream("E:\\java_class\\file\\password.txt");
			fot.write(b,0,b.length);
			System.out.println("���������룺");
			line = scanner.nextLine();
			b = line.getBytes();
			fot.write(b,0,b.length);
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			scanner.close();
			try {
				if(fot!=null) {
					fot.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
