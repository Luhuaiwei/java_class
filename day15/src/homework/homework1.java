package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class homework1 {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("С��", 19));
		list.add(new Student("С��", 40));
		list.add(new Student("С��", 32));
		list.add(new Student("С��", 18));
		list.add(new Student("С��", 50));
		
		for (int i = 0; i < list.size()-1; i++) {
			for(int j = i+1; j < list.size()-1; j++) {
				if(list.get(i).getAge()>list.get(j).getAge()) {
					Student temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);				
				}
			}			
		}	
		System.out.println(list);		
	}

}
