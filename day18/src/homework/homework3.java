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
		System.out.println("***欢迎来到大佬做的登录系统***");
		
		while(true) {
			System.out.println("\t登录界面");
			String username = null;
			String password = null;
			try {
				System.out.println("\t请输入用户名");
				username = br.readLine();
				System.out.println("\t请输入密码");
				password = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			//加载当前密码文件
			Map<String,String> map = load_passwd();
			//将密码文件转化成的MAP集合中的键转化成Set集合
			Set<String> set = new HashSet<>();
			set = map.keySet();
			//比较输入的username有没有出现在set集合中
			if(set.contains(username)) {
				if(password.equals(map.get(username))) {
					System.out.println("*********登录成功*********");
					break;
				}else {
					System.out.println("---------密码错误---------");
					System.out.println("\t是否更改密码");
					changePasswd(br,username,map);					
				}
			}else {
				System.out.println("\t用户名不存在");
				register(br,set);
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//进行密码更改操作
	private static void changePasswd(BufferedReader br, String username, Map<String, String> map) {
		System.out.println("\t输入y进行密码更改");
		BufferedWriter bw = null;
		try {
			String y = br.readLine();
			if("y".equals(y)) {
				System.out.println("\t请输入新密码");
				String password1 = br.readLine();
				System.out.println("\t请验证新密码");
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
					System.out.println("\t密码更改成功");
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

	//进行注册操作
	private static void register(BufferedReader br, Set<String> set) {
		System.out.println("\t注册界面");
		System.out.println("\t输入y进行注册");
		BufferedWriter bw = null;
		try {		
			String y = br.readLine();
			if("y".equals(y)) {
				System.out.println("\t请输入用户名");
				String username = br.readLine();
				if(set.contains(username)) {
					System.out.println("\t用户已存在");
					register(br,set);
				}else {
					System.out.println("\t请输入密码");
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
	//加载当前密码文件，返回用户名-密码Map集合
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
