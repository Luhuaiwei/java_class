package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class homework1 {

	public static void main(String[] args) {
		//���񣺴Ӽ�����������ѧ����Ϣ�������л���Ȼ���ٽ��䷴���л�
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		
		//1���Ӽ��̻������ѧ����Ϣ����װ��������	
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("������ѧ����Ϣ�������ʽ��  С����18");
		String line1 = null;
		String line2 = null;
		String line3 = null;
		try {
			line1 = br.readLine();
			System.out.println("���ٴ�����ѧ����Ϣ");
			line2 = br.readLine();
			System.out.println("���ٴ�����ѧ����Ϣ");
			line3 = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] lines1 = line1.split("��");
		String[] lines2 = line2.split("��");
		String[] lines3 = line3.split("��");
		stu1.setName(lines1[0]);
		stu1.setAge(Integer.valueOf(lines1[1]));
		//System.out.println("����valueOf��Ч����"+Integer.valueOf(lines1[1]));
		stu2.setName(lines2[0]);
		stu2.setAge(Integer.valueOf(lines2[1]));
		stu3.setName(lines3[0]);
		stu3.setAge(Integer.valueOf(lines3[1]));
		//System.out.println("���Զ��������"+stu1+stu2+stu3);
		
		//2�����������л���test_Serializable��
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("test_Serializable"));
			oos.writeObject(stu1);
			oos.writeObject(stu2);
			oos.writeObject(stu3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//3�����������л�
		BufferedWriter bw = null;
		Student stu;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("test_Serializable"));
			for (int i = 0; i < 3; i++) {
				//System.out.println("����ѭ���˼��Σ�");
				stu = (Student) ois.readObject();
				System.out.println(stu);
/*				//ʹ�û������Ĵ�ӡ����
				bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write(stu.getName() + ":" + stu.getAge());
				bw.newLine();
				bw.flush();*/
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
