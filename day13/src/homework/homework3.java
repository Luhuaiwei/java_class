package homework;

public class homework3 {

	public static void main(String[] args) {
		//用s来做剪切的操作，sb保持插入的状态
		String s = "我与父亲不想见已二年余了, 我最不能忘记的是他的背影";	
		StringBuilder sb = new StringBuilder(s);		
		
		//定义一个计数器，用来计算序列中有几个“我”
		//以便确认下面的循环次数及相关处理
		int sum=0;
		while(s.contains("我")) {
			int index = s.indexOf("我");
			sb.insert(index+(sum*3), "\"");
			sb.insert(index+2+(sum*3), "\"");
			s = s.substring(index+1);
			sum++;
		}
		
		System.out.println(sb);
		System.out.println(s);
		
	}

}
