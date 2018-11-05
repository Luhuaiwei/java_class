package homework;

import java.util.ArrayList;
import java.util.List;

public class homework5_2 {

	public static void main(String[] args) {
		Student stu1 = new Student("小明", 18, 90, "一班");
		Student stu2 = new Student("小白", 18, 60, "一班");
		Student stu3 = new Student("小红", 16, 75, "一班");
		Student stu4 = new Student("小张", 15, 73, "一班");
		Student stu5 = new Student("小王", 17, 27, "二班");
		Student stu6 = new Student("小法", 19, 80, "二班");
		Student stu7 = new Student("小仨", 15, 63, "二班");
		Student stu8 = new Student("小爱", 17, 46, "三班");
		Student stu9 = new Student("小萨", 18, 74, "三班");
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
		
		//求所有学生的平均年龄
		double avg;
		double sum= 0.0;
		for(Student stu:list) {
			sum+=stu.getAge();
		}
		avg = sum/list.size();
		System.out.println(avg);
		
		//求各班级的平均成绩
		//1.先找出有多少个班级&班级名称
		//1.1将list中的数据复制到listClass中，list中数据要不动，listClass中用来保存有哪些班级
		List<String> listClass = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listClass.add(list.get(i).getClassNum());	
		}
		//1.2去除重复的班级，并将不重复的班级保留
		for (int i = 0; i < listClass.size(); i++) {
			for (int j = i+1; j < listClass.size(); j++) {
				if(listClass.get(i).equals(listClass.get(j))) {
					listClass.remove(j);
					j--;
				}
			}
		}
		//2.根据班级求各平均分数
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
			System.out.println(listClass.get(i)+"的平均分是："+avg_score);
		}

	}

}
