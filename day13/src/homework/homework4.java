package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class homework4 {

	public static void main(String[] args) throws ParseException {
		
		//����Ӧ������������ˣ���ĿӦ���ǿ���Date��Calendar���÷�
/*		Scanner scanner = new Scanner(System.in);
		System.out.println("�������һ��ʱ�䣨�죩");
		String day1 = scanner.nextLine();
		System.out.println("������ڶ���ʱ�䣨�죩");
		String day2 = scanner.nextLine();			
		int day11 = (int) Math.ceil(Double.parseDouble(day1));
		int day22 = (int) Math.ceil(Double.parseDouble(day2));	
		int sum = Math.abs(day22-day11);	
		System.out.println("�����������"+sum+"��");
		scanner.close();*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������һ��ʱ�䣨�죩");
		String day1 = scanner.nextLine();
		System.out.println("������ڶ���ʱ�䣨�죩");
		String day2 = scanner.nextLine();			
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");	
		
		Date date1 = new Date();
		Date date2 = new Date();
		date1 = sdf1.parse(day1);
		date2 = sdf2.parse(day2);
		
		long sum = Math.abs(date1.getTime()-date2.getTime());
		long day = (long) Math.ceil(sum/(1000*3600*24.0));
		
/*		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		
		int sum = Math.abs(calendar1.get(Calendar.YEAR)-calendar2.get(Calendar.YEAR));*/
		System.out.println(day);
		scanner.close();
	}

}
