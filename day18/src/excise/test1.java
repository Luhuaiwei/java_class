package excise;

public class test1 {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29};
		int start = 0;
		int end = arr.length-1;
		int num = 33;
		//int out = myBia(arr,num,start,end);
		int out = rank(arr,num);
		System.out.println(out);

	}

	private static int rank(int[] arr, int num) {
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if (arr[mid] > num ) end = mid-1;
			else if(arr[mid] < num ) start = mid+1;
			else return mid;
		}
		return -1;
	}

}
