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
import org.apache.log4j.Logger;

public class test3 {
	
	private static Logger loger = Logger.getLogger(test3.class);
	
	public static void main(String[] args) throws IOException {
		
		//��ȡһ���ı���ÿ���ַ����ֵĴ���,�����д��times.txt��
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
		loger.error("Error");
		loger.debug("I am gonna to fly");
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\java_class\\file\\abc\\times.txt"));
		Set<Map.Entry<Integer,Integer>> set = new HashSet<>();
		set = map.entrySet();
		for(Entry<Integer, Integer> temp: set) {
			System.out.println(temp.getKey()+":"+temp.getValue());
		}
	}
}
