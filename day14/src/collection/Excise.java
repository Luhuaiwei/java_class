package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Excise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student("小红",17,"女");
		Student stu2 = new Student("小名",18,"男");
		Student stu3 = new Student("小名",18,"男");
		Student stu4 = new Student("小红",18,"男");
		Student stu5 = new Student("小名",18,"男");
		
		Collection<Student> collection = new ArrayList<>();
		collection.add(stu1);
		collection.add(stu2);
		collection.add(stu3);		
		collection.add(stu4);
		collection.add(stu5);
		//String s = collection.get(0).getName();
		//System.out.println(s);		
/*		if(collection.contains(stu2)) {
			System.out.println("列表中有"+stu2.getName());
		}*/		
		Iterator<Student> it = collection.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
			if("小红".equals(it.next().getName())) {
				collection.remove(it.next());
			}
			//System.out.println(it.next().getName());
			
		}
		
		
		
		
		
	}

}
