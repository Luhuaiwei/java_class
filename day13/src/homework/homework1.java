package homework;

import java.util.Scanner;

public class homework1 {

	public static void main(String[] args) {
		String s = "";
		String temp ;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			temp = scanner.next();
			System.out.println("temp:"+temp);
			if(temp.equals("结束")) {
				String[] ss = s.split("_");
				int[] arr = new int[s.length()];				
				for(int i=0;i<ss.length;i++) {
					arr[i]=Integer.parseInt(ss[i]);
					System.out.println("遍历数组："+arr[i]);
				}
				break;		
			}else {
				try {
					int t =Integer.parseInt(temp);
					s = s+temp+"_";
					System.out.println("s:"+s);	
				} catch (NumberFormatException e) {
				}				
			}			
		}
		scanner.close();
		
/*		Scanner scanner = new Scanner(System.in);
		String s = "";
		StringBuilder sb = new StringBuilder(s);
		while(true) {
			sb.append(scanner.next());
			if(scanner.hasNext("结束")) {
				int[] arr = new int[sb.length()];
				String s1= sb.toString();
				arr = 
				System.out.println();
				scanner.close();
			}
		}*/
		
		
		

	}

}
