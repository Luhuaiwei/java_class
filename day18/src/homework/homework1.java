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
		//任务：从键盘输入三个学生信息后将其序列化，然后再将其反序列化
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		
		//1、从键盘获得三个学生信息并封装到对象中	
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("请输入学生信息：输入格式如  小明，18");
		String line1 = null;
		String line2 = null;
		String line3 = null;
		try {
			line1 = br.readLine();
			System.out.println("请再次输入学生信息");
			line2 = br.readLine();
			System.out.println("请再次输入学生信息");
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
		String[] lines1 = line1.split("，");
		String[] lines2 = line2.split("，");
		String[] lines3 = line3.split("，");
		stu1.setName(lines1[0]);
		stu1.setAge(Integer.valueOf(lines1[1]));
		//System.out.println("测试valueOf的效果："+Integer.valueOf(lines1[1]));
		stu2.setName(lines2[0]);
		stu2.setAge(Integer.valueOf(lines2[1]));
		stu3.setName(lines3[0]);
		stu3.setAge(Integer.valueOf(lines3[1]));
		//System.out.println("测试对象情况："+stu1+stu2+stu3);
		
		//2、将对象序列化到test_Serializable中
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
		
		//3、将对象反序列化
		BufferedWriter bw = null;
		Student stu;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("test_Serializable"));
			for (int i = 0; i < 3; i++) {
				//System.out.println("这里循环了几次？");
				stu = (Student) ois.readObject();
				System.out.println(stu);
/*				//使用缓冲流的打印方法
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
