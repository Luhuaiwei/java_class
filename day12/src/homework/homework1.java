package homework;

public class homework1 {

	public static void main(String[] args) {
		//第一小题
		String s = "ABCDEabcd123456!@#$%^";
		int sum1=0; //统计大写字母的个数
		int sum2=0; //统计小写字母的个数
		int sum3=0; //统计数字的个数
		int sum4=0; //统计其它字符的个数
		
		char[] arr = s.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			int temp = arr[i];
			if(temp>=97&&temp<=122) {
				sum2++;
			}else if(temp>=65&&temp<=90) {
				sum1++;
			}else if(temp>=48&&temp<=57) {
				sum3++;
			}else {
				sum4++;
			}
		}
		System.out.println("字符串中共有大写字母"+sum1+"个");
		System.out.println("字符串中共有小写字母"+sum2+"个");
		System.out.println("字符串中共有数字"+sum3+"个");
		System.out.println("字符串中共有其它字符"+sum4+"个");
		

		
		
	}

}
