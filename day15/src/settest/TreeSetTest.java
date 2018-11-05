package settest;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Student stu1 = new Student("小李",80.0,80.0,80.0);
		Student stu2 = new Student("小王",90.0,70.0,98.0);
		Student stu3 = new Student("小张",78.0,98.0,60.0);
		Student stu4 = new Student("小站",89.0,88.0,98.0);
		Student stu5 = new Student("小白",97.0,57.0,87.0);
		
		TreeSet<Student> stus = new TreeSet<Student>(new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s0) {
				return (int) ((s0.getChinese()+s0.getEnglish()+s0.getMath())-(s1.getChinese()+s1.getEnglish()+s1.getMath()));
			}
		});
		
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		stus.add(stu4);
		stus.add(stu5);
		
		System.out.println(stus);
		

	}

}
