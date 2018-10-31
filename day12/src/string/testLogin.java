package string;

import java.util.Scanner;

public class testLogin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please put name");
		String name = scanner.nextLine();
		int i = 3;
		while(i>1) {
			i--;
			System.out.println("please put password");
			String passwd = scanner.nextLine();
			if("admin".equals(passwd)) {
				System.out.println("log up");
			}else {
				System.out.println("password error,you have"+i+"times more");
			}
		}
		scanner.close();

	}

}

