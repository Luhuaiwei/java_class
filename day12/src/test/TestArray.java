package test;

public class TestArray {

	public static void main(String[] args) {
		//String[] arr =  {"hahah","aa","sf"};
		//arr = new String[] {};
		//arr = new String[3];
		
/*		Object[] obj = new Object[3];
		obj[0] = new String("ss");
		obj[1] = new StringBuffer("sss");
		obj[2] = new StringBuilder("ssss");
		for(Object temp : obj) {
			System.out.println(temp);
		}*/
		
		char[] arr = new char[3];
		for(char temp:arr) {
			System.out.println(temp);
		}
		System.out.println('\u0000');
		System.out.println("\u0000");
		

	}

}
