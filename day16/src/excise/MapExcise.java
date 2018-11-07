package excise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExcise {

	public static void main(String[] args) {
		Map<String,Student> map = new HashMap<>();
		map.put("小明", new Student("王小明",18));
		map.put("小都", new Student("刘小都",18));
		map.put("小对", new Student("王对都",18));
		map.put("小是", new Student("赵是",18));
		map.put("小该", new Student("卢不该",18));
		
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
