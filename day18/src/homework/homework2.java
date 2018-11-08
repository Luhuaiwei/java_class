package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class homework2 {

	public static void main(String[] args) {
		BufferedReader br = null;
		String line ;
		List<Student> list =new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("student.txt"));
			while((line = br.readLine())!= null) {
				String[] lines = line.split(",");
				Student stu = new Student(lines[0],Integer.valueOf(lines[1]),lines[2]);
				list.add(stu);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		for(Student stu : list) {
			System.out.println(stu.getName()+"-"+stu.getAge()+"-"+stu.getScore());
		}
	}

}
