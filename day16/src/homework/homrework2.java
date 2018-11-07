package homework;

import java.util.ArrayList;
import java.util.List;

public class homrework2 {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("abc");
		list1.add("efg");
		list1.add("xyz");
		list2.add("abc");
		list2.add("uvw");
		System.out.println("集合A:"+list1);
		System.out.println("集合B:"+list2);
		
		List<String> bing = new ArrayList<String>();
		List<String> jiao = new ArrayList<String>();
		bing.addAll(list1);
		bing.addAll(list2);
		System.out.println("并集:"+bing);
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if(list1.get(i).equals(list2.get(j))) {
					jiao.add(list2.get(j));
				}
			}
		}
		System.out.println("交集:"+jiao);
		bing.removeAll(jiao);
		System.out.println("差集:"+bing);		
	}
}
