package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class homework5_1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		
		list.add("���ص���");
		list.add("����͢");
		list.add("�Ĵ�����");
		list.add("����ά��");
		list.add("����");
		list.add("��������");
		list.add("�ձ�");
		list.add("����");
		list.add("�й�");
		list.add("������");
		list.add("����");
		list.add("����ʱ");
		list.add("����");
		list.add("����¡");
		list.add("�鶼��˹");
		list.add("�����");

		List<String> list1 = getRandom(list);
		List<String> list2= getRandom(list);
		List<String> list3 = getRandom(list);
		List<String> list4 = getRandom(list);
		for (int i = 0; i < 4; i++) {
			System.out.println("��1��"+list1.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("��2��"+list2.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("��3��"+list3.get(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.println("��4��"+list4.get(i));
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
