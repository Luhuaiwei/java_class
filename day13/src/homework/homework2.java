package homework;

import java.util.Scanner;

public class homework2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		StringBuilder sb = new StringBuilder(line);
		sb.reverse();
		StringBuilder sb1 = new StringBuilder(line);
		
		//ע��㣺StringBuilder��StringBufferû�ж�equals������д
		if(sb.toString().equals(sb1.toString())) {
			System.out.println("���ַ����ǶԳƵ�");
		}else {
			System.out.println("���ַ������Գ�");
		}
		
		System.out.println(sb);
		System.out.println(sb1);
		
		scanner.close();
		

	}

}
