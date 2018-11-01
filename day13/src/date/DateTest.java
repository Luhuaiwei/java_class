package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		Date time = new Date();
		time = sdf.parse(s);
		long s1 = time.getTime();
		System.out.println(s1+"ms");
		scanner.close();
	}

}
