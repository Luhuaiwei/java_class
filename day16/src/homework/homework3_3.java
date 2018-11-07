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
			File file2 = new File(file,temp);
			if(file2.isDirectory()) {
				String[] filelist2 = file2.list();
				for(String temp2 : filelist2) {
					System.out.println("    |-----"+temp2);
				}
			}
			
		}
		
		scanner.close();

	}

}
