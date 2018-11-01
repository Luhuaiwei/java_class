package homework;

public class homework4 {

	public static void main(String[] args) {
		// 第四小题
		String sb = "Adcddkiqooqkdddleef";
		String ss = "dd";
		int count = 0;
		
		while(sb.contains(ss)) {
			int index = sb.indexOf(ss);
			sb = sb.substring(index+1);
			count++;
		}
		
		System.out.println(count);
	
	}

}
