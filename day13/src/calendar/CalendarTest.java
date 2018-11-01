package calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 2, 29);
	    calendar.add(Calendar.YEAR, 1);
	    Date date = new Date();
	    date = calendar.getTime();
	    System.out.println(date);
	    date.getTime();
	    System.out.println(date);
	}

}
