package homework.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import homework.homework3;

class homework3Test2 {

	@Test
	void testChangePasswd() {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));	
		String username = "Â¬»³Î°";
		Map<String,String> map = new HashMap<>();
		String line ;
		BufferedReader brf = null;
		try {
			brf =new BufferedReader(new FileReader("user.txt"));
			while((line = brf.readLine())!= null) {
				String[] temp = line.split(",");
				map.put(temp[0], temp[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(brf!=null) {
				try {
					brf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		homework3.changePasswd(br,username,map);
		fail("Not yet implemented");
	}

}
