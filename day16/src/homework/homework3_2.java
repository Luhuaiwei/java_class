package homework;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class homework3_2 {

	public static void main(String[] args) {
		String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] colors = {"黑桃","红桃","梅花","方片"};
		
		//任务：模拟斗地主的运行
		//1、先创建一副牌
		ArrayList<String> cards = new ArrayList<>();
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				String card = colors[i]+nums[j];
				cards.add(card);
			}
		}
		cards.add("小王");
		cards.add("大王");
		
		//2、洗牌
		for (int i = 0; i < 1000 ; i++) {
			Random random = new Random();
			String temp ;
			int a = random.nextInt(cards.size());
			int b = random.nextInt(cards.size());
			temp = cards.get(a);
			cards.set(a, cards.get(b));
			cards.set(b, temp);	
		}
		//System.out.println(cards);
		
		//3、发牌
		ArrayList<String> spec = new ArrayList<>();
		ArrayList<String> dizhu = new ArrayList<>();
		ArrayList<String> nm1 = new ArrayList<>();
		ArrayList<String> nm2 = new ArrayList<>();
		//3.1设置地主牌
		for (int i = 0; i < 3; i++) {
			spec.add(cards.get(i));
			cards.remove(i);
		}
		//3.2正式发牌
		for (int i = 0; i < cards.size(); i++) {
			if(i%3 == 0 ) {
				dizhu.add(cards.get(i));
			}else if(i%3 == 1) {
				nm1.add(cards.get(i));
			}else {
				nm2.add(cards.get(i));
			}
		}
		dizhu.addAll(spec);
		System.out.println("荷官自动发牌：");
		//System.out.println(spec);
		System.out.println(dizhu);
		System.out.println(nm1);
		System.out.println(nm2);
		
		//4、对发到的牌进行排序		
		dizhu = mySort(dizhu);
		nm1 = mySort(nm1);
		nm2 = mySort(nm2);
		System.out.println("自动排序：");
		System.out.println(dizhu);
		System.out.println(nm1);
		System.out.println(nm2);		
	}

	//排序算法
	private static ArrayList<String> mySort(ArrayList<String> dizhu) {
		ArrayList<String> sort_list = new ArrayList<>();
		ArrayList<String> sort_temp = new ArrayList<>();
		ArrayList<String> sort_temp2 = new ArrayList<>();
		ArrayList<String> sort_temp3 = new ArrayList<>();
		//1、将集合中字符串第一个角标和第三个角标上的元素转换，便于比较
		//用来比较9-3排序
		for (int i = 0; i < dizhu.size(); i++) {
			String s = dizhu.get(i);
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			sort_temp.add(sb.toString());
		}
		//System.out.println("转换后"+sort_temp);		
		TreeSet<String> ts = new TreeSet<>(sort_temp);
		sort_temp2.addAll(ts);
		//System.out.println("排序后"+sort_temp2);
		//大小王比较特殊，可以直接拉出来
		if(sort_temp2.contains("王大")) {
			sort_list.add("王大");
			sort_temp2.remove("王大");
		}
		if(sort_temp2.contains("王小")) {
			sort_list.add("王小");
			sort_temp2.remove("王小");
		}
		sort_temp2 = mySortB(sort_temp2,sort_list,"2桃黑","2桃红","2花梅","2片方");
		sort_temp2 = mySortB(sort_temp2,sort_list,"A桃黑","A桃红","A花梅","A片方");
		sort_temp2 = mySortB(sort_temp2,sort_list,"K桃黑","K桃红","K花梅","K片方");
		sort_temp2 = mySortB(sort_temp2,sort_list,"Q桃黑","Q桃红","Q花梅","Q片方");
		sort_temp2 = mySortB(sort_temp2,sort_list,"J桃黑","J桃红","J花梅","J片方");
		sort_temp2 = mySortB(sort_temp2,sort_list,"01桃黑","01桃红","01花梅","01片方");	
		for (int i = 0; i < sort_temp2.size(); i++) {
			sort_list.add(sort_temp2.get(sort_temp2.size()-1-i));		
		}	
		for (int i = 0; i < sort_list.size(); i++) {
			String s = sort_list.get(i);
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			sort_list.set(i,sb.toString());
		}
		return sort_list;
	}
	//排序算法第二层
	private static ArrayList<String> mySortB(ArrayList<String> sort_temp2, ArrayList<String> sort_list, String string,
			String string2, String string3, String string4) {
		while(sort_temp2.contains(string)||sort_temp2.contains(string2)||sort_temp2.contains(string3)||sort_temp2.contains(string4)) {
			sort_temp2 = mySortC(sort_temp2,sort_list,string);
			sort_temp2 = mySortC(sort_temp2,sort_list,string2);
			sort_temp2 = mySortC(sort_temp2,sort_list,string3);
			sort_temp2 = mySortC(sort_temp2,sort_list,string4);
		}
		return sort_temp2;	
	}
	//排序算法第三层
	private static ArrayList<String> mySortC(ArrayList<String> sort_temp2, ArrayList<String> sort_list, String string) {
		if(sort_temp2.contains(string)) {
			sort_list.add(string);
			sort_temp2.remove(string);
		}
		return sort_temp2;
	}
}
