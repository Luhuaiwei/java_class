package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class homework5_1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		
		list.add("科特迪瓦");
		list.add("阿根廷");
		list.add("澳大利亚");
		list.add("塞尔维亚");
		list.add("荷兰");
		list.add("尼日利亚");
		list.add("日本");
		list.add("美国");
		list.add("中国");
		list.add("新西兰");
		list.add("巴西");
		list.add("比利时");
		list.add("韩国");
		list.add("喀麦隆");
		list.add("洪都拉斯");
		list.add("意大利");

		List<String> list1 = getRandom(list);
		List<String> list2= getRandom(list);
		List<String> list3 = getRandom(list);
		List<String> list4 = getRandom(list);
		for (int i = 0; i < 4; i++) {
			System.out.println("组1："+list1.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("组2："+list2.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("组3："+list3.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("组4："+list4.get(i));
		}
		
		
		

	}

	private static List<String> getRandom(List<String> list) {
		Random random = new Random();
		List<String> ls = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int r = random.nextInt(list.size());
			ls.add(list.get(r));
			list.remove(r);
		}		
		return ls;
	}

}
