package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class homework2 {

	public static void main(String[] args) {
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		
		stu1.setName("С��");
		stu2.setName("С��");
		stu3.setName("С��");
		stu4.setName("С��");
		stu1.setAge(14);
		stu2.setAge(16);
		stu3.setAge(19);
		stu4.setAge(12);
		
		List<Student> list = new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		Iterator<Student> iterator = list.iterator();
		int maxage = 0;
/*		while(iterator.hasNext()) {
			Student s = iterator.next();
			if(s.getAge() > maxage) {
				maxage = s.getAge();
			}
		}*/
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAge()>maxage) {
				maxage = list.get(i).getAge();
			}
		}
		System.out.println(maxage);
		System.out.println("������������");
		while(iterator.hasNext()) {
			Student s = iterator.next();
			if(s.getAge() == maxage) {
				System.out.println(s.getName());
			}
		}

/*		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAge() == maxage) {
				System.out.println(list.get(i).getName());
			}
		}	*/	
		

	}

}
