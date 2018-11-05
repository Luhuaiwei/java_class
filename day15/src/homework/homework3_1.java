package homework;

import java.util.Comparator;
import java.util.TreeSet;

public class homework3_1 {

	public static void main(String[] args) {
		String s = "asdjfksnldkfnhbahsd";
		char[] c = s.toCharArray();
		
		
		TreeSet<Character> ts = new TreeSet<Character>(new Comparator<Character>() {
			@Override
			public int compare(Character arg0, Character arg1) {
				int sum = arg0-arg1;
				return sum==0?1:sum;
			}
		});
		
		for(char temp : c) {
			ts.add(temp);
		}
		
		System.out.println(ts);
		
	}

}
