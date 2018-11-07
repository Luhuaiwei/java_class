package homework;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class homework3_2 {

	public static void main(String[] args) {
		String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] colors = {"����","����","÷��","��Ƭ"};
		
		//����ģ�⶷����������
		//1���ȴ���һ����
		ArrayList<String> cards = new ArrayList<>();
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				String card = colors[i]+nums[j];
				cards.add(card);
			}
		}
		cards.add("С��");
		cards.add("����");
		
		//2��ϴ��
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
		
		//3������
		ArrayList<String> spec = new ArrayList<>();
		ArrayList<String> dizhu = new ArrayList<>();
		ArrayList<String> nm1 = new ArrayList<>();
		ArrayList<String> nm2 = new ArrayList<>();
		//3.1���õ�����
		for (int i = 0; i < 3; i++) {
			spec.add(cards.get(i));
			cards.remove(i);
		}
		//3.2��ʽ����
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
		System.out.println("�ɹ��Զ����ƣ�");
		//System.out.println(spec);
		System.out.println(dizhu);
		System.out.println(nm1);
		System.out.println(nm2);
		
		//4���Է������ƽ�������		
		dizhu = mySort(dizhu);
		nm1 = mySort(nm1);
		nm2 = mySort(nm2);
		System.out.println("�Զ�����");
		System.out.println(dizhu);
		System.out.println(nm1);
		System.out.println(nm2);		
	}

	//�����㷨
	private static ArrayList<String> mySort(ArrayList<String> dizhu) {
		ArrayList<String> sort_list = new ArrayList<>();
		ArrayList<String> sort_temp = new ArrayList<>();
		ArrayList<String> sort_temp2 = new ArrayList<>();
		ArrayList<String> sort_temp3 = new ArrayList<>();
		//1�����������ַ�����һ���Ǳ�͵������Ǳ��ϵ�Ԫ��ת�������ڱȽ�
		//�����Ƚ�9-3����
		for (int i = 0; i < dizhu.size(); i++) {
			String s = dizhu.get(i);
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			sort_temp.add(sb.toString());
		}
		//System.out.println("ת����"+sort_temp);		
		TreeSet<String> ts = new TreeSet<>(sort_temp);
		sort_temp2.addAll(ts);
		//System.out.println("�����"+sort_temp2);
		//��С���Ƚ����⣬����ֱ��������
		if(sort_temp2.contains("����")) {
			sort_list.add("����");
			sort_temp2.remove("����");
		}
		if(sort_temp2.contains("��С")) {
			sort_list.add("��С");
			sort_temp2.remove("��С");
		}
		sort_temp2 = mySortB(sort_temp2,sort_list,"2�Һ�","2�Һ�","2��÷","2Ƭ��");
		sort_temp2 = mySortB(sort_temp2,sort_list,"A�Һ�","A�Һ�","A��÷","AƬ��");
		sort_temp2 = mySortB(sort_temp2,sort_list,"K�Һ�","K�Һ�","K��÷","KƬ��");
		sort_temp2 = mySortB(sort_temp2,sort_list,"Q�Һ�","Q�Һ�","Q��÷","QƬ��");
		sort_temp2 = mySortB(sort_temp2,sort_list,"J�Һ�","J�Һ�","J��÷","JƬ��");
		sort_temp2 = mySortB(sort_temp2,sort_list,"01�Һ�","01�Һ�","01��÷","01Ƭ��");	
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
	//�����㷨�ڶ���
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
	//�����㷨������
	private static ArrayList<String> mySortC(ArrayList<String> sort_temp2, ArrayList<String> sort_list, String string) {
		if(sort_temp2.contains(string)) {
			sort_list.add(string);
			sort_temp2.remove(string);
		}
		return sort_temp2;
	}
}
