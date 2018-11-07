package homework;

import java.io.File;
import java.util.Scanner;

public class homework3_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		File file = new File(line);
		String[] filelist = file.list();
		for(String temp : filelist) {
			System.out.println("---"+temp);
			myFind(file,temp,1);		
		}
		
		scanner.close();

	}
	private static void myFind(File file, String temp,int sum) {
		File file2 = new File(file,temp);
		String s = "        ";
		int sum1 = sum+1;
		if(file2.isDirectory()) {
			String[] filelist2 = file2.list();
			for(String temp2 : filelist2) {
				for (int i = 0; i < sum; i++) {
					System.out.print(s);
				}
				System.out.println("|-----"+temp2);
				myFind(file2,temp2,sum1);
			}
		}
		
	}

}
