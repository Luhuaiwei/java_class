package homework;

import java.util.ArrayList;
import java.util.List;

public class homework5_2 {

	public static void main(String[] args) {
		Student stu1 = new Student("С��", 18, 90, "һ��");
		Student stu2 = new Student("С��", 18, 60, "һ��");
		Student stu3 = new Student("С��", 16, 75, "һ��");
		Student stu4 = new Student("С��", 15, 73, "һ��");
		Student stu5 = new Student("С��", 17, 27, "����");
		Student stu6 = new Student("С��", 19, 80, "����");
		Student stu7 = new Student("С��", 15, 63, "����");
		Student stu8 = new Student("С��", 17, 46, "����");
		Student stu9 = new Student("С��", 18, 74, "����");
		List<Student> list = new ArrayList<>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		list.add(stu6);
		list.add(stu7);
		list.add(stu8);
		list.add(stu9);
		
		//������ѧ����ƽ������
		double avg;
		double sum= 0.0;
		for(Student stu:list) {
			sum+=stu.getAge();
		}
		avg = sum/list.size();
		System.out.println(avg);
		
		//����༶��ƽ���ɼ�
		//1.���ҳ��ж��ٸ��༶&�༶����
		//1.1��list�е����ݸ��Ƶ�listClass�У�list������Ҫ������listClass��������������Щ�༶
		List<String> listClass = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listClass.add(list.get(i).getClassNum());	
		}
		//1.2ȥ���ظ��İ༶���������ظ��İ༶����
		for (int i = 0; i < listClass.size(); i++) {
			for (int j = i+1; j < listClass.size(); j++) {
				if(listClass.get(i).equals(listClass.get(j))) {
					listClass.remove(j);
					j--;
				}
			}
		}
		//2.���ݰ༶���ƽ������
		for(int i=0;i<listClass.size();i++) {
			int count = 0;
			double sum_score = 0.0;
			double avg_score = 0.0;
			for(int j=0;j<list.size();j++) {
				if(listClass.get(i).equals(list.get(j).getClassNum())) {
					sum_score += list.get(j).getScore();
					count++;
				}
			}
			avg_score = sum_score/count;
			System.out.println(listClass.get(i)+"��ƽ�����ǣ�"+avg_score);
		}

	}

}
