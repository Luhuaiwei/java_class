package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class homework3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		Iterator<String> iterator = list.iterator();
		list.add("I");
		list.add("am");
//		list.add("the");
		list.add("best");
		int start = 0;
		int end = list.size();
		System.out.println("end="+end);
		System.out.println("before change");
/*		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list = swap(list,start,end);
		System.out.println("after change");
/*		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	private static List<String> swap(List<String> list, int start, int end) {
		String temp;
		for(int i=0;i<list.size()/2;i++) {
			temp = list.get(i);
			list.set(i, list.get(list.size()-1-i));
			list.set(list.size()-1-i, temp);
		}
		return list;
		
	}

}
