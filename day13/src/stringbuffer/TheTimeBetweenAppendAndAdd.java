package stringbuffer;

public class TheTimeBetweenAppendAndAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "";
		String s2 = "aaaaa";
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			s1 = s1+s2;
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer(s1);
		for(int i=0;i<100000;i++) {
			sb.append(s2);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		//下面就是测试一下StringBuffer的insert方法，与其他无关
		StringBuffer sb1 = new StringBuffer(s2);
		sb1.insert(2,"bbb");
		System.out.println(sb1);
		
		
	}

}
