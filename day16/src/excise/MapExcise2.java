package excise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExcise2 {

	public static void main(String[] args) {
		String s = "dfsdg;js'gafgdjksfanj0";
		String[] ss = s.split("");
		
		Map<String,Integer> map = new HashMap<>();
		for (int i = 0; i < ss.length; i++) {
			if(map.containsKey(ss[i])){
				int sum = map.get(ss[i]);
				sum++;
				map.put(ss[i], sum);
			}else {
				map.put(ss[i], 1);
			}
		
		}
		Set<String> set = map.keySet();
		System.out.println(set);
		Set<Map.Entry<String, Integer>> set2 = map.entrySet();
		System.out.println(set2);

	}

}
