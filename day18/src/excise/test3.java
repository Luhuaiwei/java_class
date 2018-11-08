package excise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test3 {
	public static void main(String[] args) throws IOException {
		//获取一个文本上每个字符出现的次数,将结果写在times.txt上
		//E:\java_class\file\abc\bbb.txt
		BufferedReader br = new BufferedReader(new FileReader("E:\\java_class\\file\\abc\\bbb.txt"));
		Map<Integer,Integer> map = new HashMap<>();
		int line;
		while((line = br.read())!=-1) {			
			if(map.get(line) == null) {
				map.put(line, 1);
			}else {
				int num = map.get(line);
				num++;
				map.put(line, num);
			}
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\java_class\\file\\abc\\times.txt"));
		Set<Map.Entry<Integer,Integer>> set = new HashSet<>();
		set = map.entrySet();
		for(Entry<Integer, Integer> temp: set) {
			System.out.println(temp.getKey()+":"+temp.getValue());
		}
	}
}
