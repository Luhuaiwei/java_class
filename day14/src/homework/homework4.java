package homework;

import java.util.ArrayList;
import java.util.List;

public class homework4 {

	public static void main(String[] args) {
		Student stu1 = new Student("小明", 20);
		Student stu2 = new Student("小王", 23);
		Student stu3 = new Student("小明", 24);
		Student stu4 = new Student("小正", 20);
		Student stu5 = new Student("小明", 21);
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
/*		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getName().equals(list.get(i+1).getName()))
			while(list.get(i).getName().equals(list.get(i+1).getName())) {
				list.remove(i+1);
			}
		}*/
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if(list.get(i).getName().equals(list.get(j).getName())) {
					list.remove(j);
					j--;
				}
			}
		}
/*		Iterator<Student> iterator = list.iterator();
		while*/
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}

		

	}

}
