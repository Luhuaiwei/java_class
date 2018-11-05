package settest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<Student> arr_stu = new ArrayList<>();
		arr.add("111");
		arr.add("222");
		arr.add("333");
		arr.add("111");
		arr.add("222");
		arr.add("333");
		Set<String> st = new HashSet<>(arr);
		System.out.println(st);
		
		arr_stu.add(new Student("小明",19));
		arr_stu.add(new Student("小阿",15));
		arr_stu.add(new Student("小宝",19));
		arr_stu.add(new Student("小明",19));
		arr_stu.add(new Student("小嗄",18));
		arr_stu.add(new Student("小部",18));
		arr_stu.add(new Student("小法",17));
		arr_stu.add(new Student("小好",15));
		
		Set<Student> st_stu = new HashSet<>(arr_stu);

		
		
		
		

	}

}
