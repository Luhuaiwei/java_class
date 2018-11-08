package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class homework3 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));		
		System.out.println("***��ӭ�����������ĵ�¼ϵͳ***");
		
		while(true) {
			System.out.println("\t��¼����");
			String username = null;
			String password = null;
			try {
				System.out.println("\t�������û���");
				username = br.readLine();
				System.out.println("\t����������");
				password = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			//���ص�ǰ�����ļ�
			Map<String,String> map = load_passwd();
			//�������ļ�ת���ɵ�MAP�����еļ�ת����Set����
			Set<String> set = new HashSet<>();
			set = map.keySet();
			//�Ƚ������username��û�г�����set������
			if(set.contains(username)) {
				if(password.equals(map.get(username))) {
					System.out.println("*********��¼�ɹ�*********");
					break;
				}else {
					System.out.println("---------�������---------");
					System.out.println("\t�Ƿ��������");
					changePasswd(br,username,map);					
				}
			}else {
				System.out.println("\t�û���������");
				register(br,set);
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//����������Ĳ���
	private static void changePasswd(BufferedReader br, String username, Map<String, String> map) {
		System.out.println("\t����y�����������");
		BufferedWriter bw = null;
		try {
			String y = br.readLine();
			if("y".equals(y)) {
				System.out.println("\t������������");
				String password1 = br.readLine();
				System.out.println("\t����֤������");
				String password2 = br.readLine();
				if(password1.equals(password2)) {
					map.put(username, password1);
					Set<Map.Entry<String, String>> entry = new HashSet<>();
					entry = map.entrySet();
					bw = new BufferedWriter(new FileWriter("user.txt"));
					for (Map.Entry<String, String> temp : entry) {
						bw.write(temp.getKey()+","+temp.getValue());
						bw.newLine();
					}
					System.out.println("\t������ĳɹ�");
					return;
				}else {
					changePasswd(br,username,map);
				}			
			}else {
				changePasswd(br,username,map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//����ע�����
	private static void register(BufferedReader br, Set<String> set) {
		System.out.println("\tע�����");
		System.out.println("\t����y����ע��");
		BufferedWriter bw = null;
		try {		
			String y = br.readLine();
			if("y".equals(y)) {
				System.out.println("\t�������û���");
				String username = br.readLine();
				if(set.contains(username)) {
					System.out.println("\t�û��Ѵ���");
					register(br,set);
				}else {
					System.out.println("\t����������");
					String password = br.readLine();
					bw = new BufferedWriter(new FileWriter("user.txt",true));
					String line = username+","+password;
					bw.newLine();
					bw.write(line);
					return;
				}
			}else {
				register(br,set);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//���ص�ǰ�����ļ��������û���-����Map����
	private static Map<String, String> load_passwd() {
		Map<String,String> map = new HashMap<>();
		String line ;
		BufferedReader brf = null;
		try {
			brf =new BufferedReader(new FileReader("user.txt"));
			while((line = brf.readLine())!= null) {
				String[] temp = line.split(",");
				map.put(temp[0], temp[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(brf!=null) {
				try {
					brf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
		
	}
	
}
