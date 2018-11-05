package settest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		//1.实现产生10个不同的字符串
		//2.产生字符串随机在1-20长度内的
		String s = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9";
		String[] ss = s.split(",");
		
		Set<String> set_string = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		while(set_string.size()<10) {
			Random random = new Random();
			Random random1 = new Random();
			int random2 =random1.nextInt(20+1)-1;
			for(int i=0;i<random2;i++) {
				int j = random.nextInt(ss.length);
				sb.append(ss[j]);
			}
			set_string.add(sb.toString());	
			
		}
		
		System.out.println(set_string);

	}

}
