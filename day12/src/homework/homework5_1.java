package homework;

import java.util.Scanner;

public class homework5_1 {

	public static void main(String[] args) {
		//二维数组
		//二维数组的静态初始化
		char[][] arrs1 = new char[][] {{},{}};
		//二维数组的动态初始化
		char[][] arrs2 = new char[2][3];
		arrs2[0][0]= 'a';
		//二维数组动态初始化时，可以不定义第二层
		//上述这种情况JVM不会为第二层开辟内存空间，待赋值的时候再分配内存
		char[][] arrs3 = new char[2][];
		//Object类
		//主要方法：
		//hashCode() 根据地址值计算的哈希码值
		//toString() 返回该对象的字符串表示，一般都需要重写
		//equals() 通过地址比较当前对象与指定对象，一般需要重写使其比较值的大小
		//== 比较基本数据类型的值，比较引用数据类型的地址是否相等。
		//一般重写equals也需重写hashCode保证equals相等的时候hashCode也相等
		//getClass() 返回对象的类
		Student stu = new Student();
		Student stu2= new Student();
		Student stu3= new Student();
	
		stu.setAge(11);
		stu3.setAge(11);
		
		boolean flg1 = stu3.equals(stu2);
		boolean flg2 = stu3.equals(stu);

		System.out.println(flg1);
		System.out.println(flg2);
		
		//Scanner类：获取一段输出流，一般用来获取键盘输入
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		//String类
		//String类能通过全部或部分的字节或字符数组以及常亮构造
		char[] arr = new char[3];
		String s = new String(arr);
		//***常用的判断方法***
		String s1 = "string";
		String s2 = "string2";
		//比较字符串内容是否相等
		boolean flg3 = s1.equals(s2);
		//忽略大小写地比较字符串内容是否相等
		boolean flg4 = s1.equalsIgnoreCase(s2);
		//判断大字符串中是否包含某小字符串
		boolean flg5 = s1.contains(s2);
		//判断字符串是否以某个字符开头
		boolean flg6 = s1.startsWith(s2);
		//判断字符串是否为空
		boolean flg7 = s1.isEmpty();
		
		//***常用的获取方法***
		//获取指定索引位置的字符
		char c = s1.charAt(0);
		//返回指定字符第一次出现的索引
		int index = s1.indexOf(c);
		//indexOf()有多重形式，能够返回指定字符字符串在某个区间内的首次索引
		//变种lastIndexOf()，基本同上，只不过是找出最后一个的索引
		int index2 = s1.lastIndexOf(c);
		//从指定索引截取字符串，默认截取到末尾
		String s3 = s2.substring(index);
		
		//***有关字符串常用的转换方法***
		//将字符串转化成字节、字符数组
		byte[] bt = s1.getBytes();
		char[] ct = s1.toCharArray();
		//将任意类型转化成字符串
		//使用valueOf()可以将任意数据类型转化出字符串
		String s4 = String.valueOf(ct);
		//将字符串转成大写、小写
		String s5 = s4.toUpperCase();
		//字符串拼接
		String s6 = s5.concat(s4);//concat相对于+有许多缺陷，搞不清concat存在的意义
		
		//其他
		//替换,用A替代a
		String s7 = s6.replace('a', 'A');
		//切割,根据
		String[] ss = s7.split(s7, ' ');//这个不晓得怎么搞
		//其他方法
		String s9 = s7.trim();
		int i = s9.compareTo(s7);
	
	}

}
