package homework;

import java.util.Scanner;

public class homework2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		StringBuilder sb = new StringBuilder(line);
		sb.reverse();
		StringBuilder sb1 = new StringBuilder(line);
		
		//注意点：StringBuilder、StringBuffer没有对equals进行重写
		if(sb.toString().equals(sb1.toString())) {
			System.out.println("该字符串是对称的");
		}else {
			System.out.println("该字符串不对称");
		}
		
		System.out.println(sb);
		System.out.println(sb1);
		
		scanner.close();
		

	}

}
