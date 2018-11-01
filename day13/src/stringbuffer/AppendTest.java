package stringbuffer;

public class AppendTest {

	public static void main(String[] args) {
		int[] arr = {5,6,7,8};
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<arr.length-1;i++) {
			sb.append(arr[i]);
			sb.append(",");
		}
		sb.append(arr[arr.length-1]);
		sb.append("]");
		String s = sb.toString();
		System.out.println(s);
		
		sb.reverse();
		String s1 = sb.toString();
		System.out.println(s1);		

	}

}
