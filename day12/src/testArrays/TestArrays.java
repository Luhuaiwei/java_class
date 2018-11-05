package testArrays;

import java.util.Arrays;

public class TestArrays {

	public static void main(String[] args) {
		int[] arr = new int[] {11,22,33,44,55,66,77,88};
		int b = Arrays.binarySearch(arr, 33);
		System.out.println(b);
		int[] arr1 = Arrays.copyOf(arr, 3);
		for(int i : arr1) {
			System.out.println(i);
		}
		boolean i = Arrays.equals(arr, arr1);
		String s = Arrays.toString(arr);
		System.out.println(s);

	}

}
