package homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class homework1 {

	public static void main(String[] args) {
		Car c1 = new Car("奥拓", 100);
		Car c2 = new Car("宝马", 200);
		Car c3 = new Car("奔驰", 300);
		Map<Car,Integer> m1 = new HashMap<>();
		m1.put(c1, 10000);
		m1.put(c2, 500000);
		m1.put(c3, 2000000);
		
		Set<Car> st = new HashSet<>();
		st = m1.keySet();
		//打印name属性
		for(Car ctemp: st) {
			System.out.println(m1.get(ctemp));
		}
		//求m1中宝马的价格
		for(Car ctemp: st) {
			if("宝马".equals(ctemp.getName())) {
				System.out.println(m1.get(ctemp));
			}
		}
		//求降速后宝马的速度
		for(Car ctemp: st) {
			if("宝马".equals(ctemp.getName())) {
				System.out.println(ctemp.getSpeed()*0.8);
			}
		}
		
	}

}
