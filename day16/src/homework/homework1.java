package homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class homework1 {

	public static void main(String[] args) {
		Car c1 = new Car("����", 100);
		Car c2 = new Car("����", 200);
		Car c3 = new Car("����", 300);
		Map<Car,Integer> m1 = new HashMap<>();
		m1.put(c1, 10000);
		m1.put(c2, 500000);
		m1.put(c3, 2000000);
		
		Set<Car> st = new HashSet<>();
		st = m1.keySet();
		//��ӡname����
		for(Car ctemp: st) {
			System.out.println(m1.get(ctemp));
		}
		//��m1�б���ļ۸�
		for(Car ctemp: st) {
			if("����".equals(ctemp.getName())) {
				System.out.println(m1.get(ctemp));
			}
		}
		//���ٺ�����ٶ�
		for(Car ctemp: st) {
			if("����".equals(ctemp.getName())) {
				System.out.println(ctemp.getSpeed()*0.8);
			}
		}
		
	}

}
