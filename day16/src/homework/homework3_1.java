package homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class homework3_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String,Integer> map = new HashMap<>();
		Set<String> int_alone = new HashSet<>();	
		while(true) {
			System.out.println("请输入整数");
			String i = scanner.next();
			int_alone.add(i);
			//将所有对象放到set中去重，用于取出有哪些整数
			//将这些整数作为键放入map中，map的值记录整数出现的个数		
			for (String temp: int_alone) {
				if(map.get(temp)!=null) {
					if(temp.equals(i)) {
						map.put(temp, map.get(temp)+1);
					}
				}else {
					map.put(temp, 1);
				}		
			}			
			//找出map中值最大的键，并通过其找到对应的键赋给keys
			Collection<Integer> values = map.values();				
			int max=0;
			for(Integer temp : values) {
				if(temp > max) {
					max = temp;
				}
			}
			Set<Map.Entry<String,Integer>> s2 = map.entrySet();	
			for(Map.Entry<String, Integer> entry : s2) {
				System.out.println("键："+entry.getKey()+"值："+entry.getValue());
			}
			List<String> keys = new ArrayList<>();
			for(Map.Entry<String, Integer> entry : s2) {
				if(entry.getValue()== max) {
					keys.add(entry.getKey());
				}
			}
			//根据键值打印出整数
			for (int j= 0; j < keys.size(); j++) {
				System.out.println(keys.get(j));					
			}
			
			
		}
	}
}
