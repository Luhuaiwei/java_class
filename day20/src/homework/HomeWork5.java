package homework;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class HomeWork5 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		Date date = cal.getTime();
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println("当当当当");
				Runtime runt = Runtime.getRuntime();
				try {
					runt.exec("E:\\英雄联盟\\英雄联盟\\TCLS\\Client.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		Timer timer = new Timer();
		timer.schedule(task, date);
	}

}
