package homework;

public class homework6 {

	public static void main(String[] args) {
		// 第六小题
		String s = "abbddAffeeEddcccwceaa";
		System.out.println("abdAfeEdcwcea");
		char[] arr = s.toCharArray();
		int len = arr.length;
		//boolean flag = isAlone(arr,len);
		//while(flag) {
			for(int i=0;i<len;i++) {
				if((i+1)!=len) {
					if(arr[i]==arr[i+1]) {		
						for(int j=i;j<len;j++) {
							if((j+1)!=len) {
								arr[j]=arr[j+1];
							}else {
								len--;
							}
						}
					}
				}
			}
		//}
		String s1 = String.valueOf(arr);
		System.out.println(len);
		String s2 = s1.substring(0,len);
		System.out.println(s2);
		//System.out.println(s2);
		
		//用数组处理复杂度过高，考虑用链表处理比较好
		//今天复习完有时间的话用集合的方式解决看看

	}

/*	private static boolean isAlone(char[] arr, int len) {
		for(int i=0;i<len-1;i++) {
			if(arr[i]==arr[i+1]) 
				return true;
			else
				return false;	
		}
		return true;
		
	}*/



}
