package homework;

public class homework5 {

	public static void main(String[] args) {
		String a = "";
		String b = "aa";
		StringBuffer sbr = new StringBuffer(a);
		StringBuilder sbd = new StringBuilder(a);
		String c = a;
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			sbr.append(b);
		}
		long end = System.currentTimeMillis();
		System.out.println("StringBuffer:"+(end-start));
		
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			sbd.append(b);
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder:"+(end-start));
		
		start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			c+=a;
		}
		end = System.currentTimeMillis();
		System.out.println("+:"+(end-start));
	}

}
