package test;

public class TestString {
	public static void main(String[] args) {
		char[] arr = new char[] {'a','b','c','d','e'};
		
		String s1 = String.valueOf(arr);
		String s2 = String.copyValueOf(arr);
		System.out.println(s1);
		System.out.println(s2);
	}
}
