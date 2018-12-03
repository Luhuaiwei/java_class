package service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.JDBCUtil;
import entity.User;
import entity.Users;

public class DBUtil {	
	public static boolean modifyPasswd(Users user){
		String sql = "update users set passwd=? where usname=?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		int count = 0;
		try {
			count = qr.update(sql, user.getPassword(),user.getUsername());
			if(count>0) {
				System.out.println("密码修改成功");
				return true;
			}else {
				System.out.println("未找到该用户名");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return false;
	}
	
	public static boolean login(Users user) {	
		String sql = "select * from users where usname = ? and passwd = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		try {
			List<User> users = qr.query(sql,new BeanListHandler<User>(User.class) ,user.getUsername(),user.getPassword());
			if(users.size()>0) {
				System.out.println("登录成功");
				System.out.println(users.get(0));
				return true;
			}else {
				System.out.println("用户名或密码错误");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return false;
	}
	
	public static boolean register(Users user) {
		String sql = "insert into users values(?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		int count = 0;
		try {
			count = qr.update(sql,user.getUsername(), user.getPassword());
			            
			if(count>0) {
				System.out.println("注册成功");
				return true;
			}else {
				System.out.println("用户名重复");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;		
	}


}
