package homework;

public class homework2 {

	public static void main(String[] args) {
		//第二小题
		int[] arr1 = {1,2,3,4,5};
		String sum = "";
		for(int i =0;i<arr1.length;i++) {
			String s1 = String.valueOf(arr1[i]);
			sum = sum+s1;	
		}
		System.out.println("["+sum+"]");
		System.out.println(arr1.length/2);
	}

}
