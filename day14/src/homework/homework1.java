package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class homework1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("I");
		list.add("am");
		list.add("the");
		list.add("best");	
		int a = 0;
		int b = 2;
		System.out.println("before change");
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
/*		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		list = swap(list,a,b);
		System.out.println("after change");
/*		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		System.out.println(list);
	}
	private static List<String> swap(List<String> list, int a, int b) {
		String temp;
		temp = list.get(b);
		list.set(b, list.get(a));
		list.set(a, temp);		
		return list;
		
	}

}
