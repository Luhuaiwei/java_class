package excise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExcise {

	public static void main(String[] args) {
		Map<String,Student> map = new HashMap<>();
		map.put("С��", new Student("��С��",18));
		map.put("С��", new Student("��С��",18));
		map.put("С��", new Student("���Զ�",18));
		map.put("С��", new Student("����",18));
		map.put("С��", new Student("¬����",18));
		
		Set<String> set1 = map.keySet();
		for(String temp :set1) {
			System.out.println(map.get(temp).getName());
		}
		
		Set<Map.Entry<String, Student>> set2 = map.entrySet();
		for(Map.Entry<String,Student> temp : set2) {
			System.out.print(temp.getKey());
			System.out.println(temp.getValue());
		}
		
		Collection<Student> collect = map.values();
		
		
		
		
	}

}
