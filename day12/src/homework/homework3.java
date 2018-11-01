package homework;

import java.util.Scanner;

public class homework3 {

	public static void main(String[] args) {
		// 第三小题
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		char[] arr = s.toCharArray();
		for(int i=0;i<=(arr.length/2);i++) {
			char temp;
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		String s1 = String.valueOf(arr);
		System.out.println(s1);
	}

}
