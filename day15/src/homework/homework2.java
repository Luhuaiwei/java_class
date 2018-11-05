package homework;

import java.util.Arrays;
import java.util.Scanner;

public class homework2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.nextLine();
		String[] ss = s.split("");
		Arrays.sort(ss);
		for(String temp:ss) {
			System.out.print(temp);
		}
		

	}

}
