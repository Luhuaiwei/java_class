package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import dao.JDBCBase;
import entity.Users;

public class usersCURD {	
	private static Logger loger = Logger.getLogger(usersCURD.class);
	
	public static boolean modifyPasswd(Users user) {
		Connection conn = JDBCBase.getConnection();
		String sql = "update users set passwd=? where usname=?";
		PreparedStatement ps = null;	
		try {
			ps=conn.prepareCall(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			int num = ps.executeUpdate();
			if(num>0) {
				loger.debug("修改成功");
				return true;
			}else {
				loger.debug("找不到用户名");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			closeAll(conn,ps,null);
		}					
		return false;
	}
	
	public static boolean login(Users user) {	
		Connection conn = JDBCBase.getConnection();
		String sql = "select * from users where usname = ? and passwd = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareCall(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				loger.debug("登录成功");
				return true;
			}else {
				loger.debug("登录失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn,ps,rs);
		}
		return false;
	}
	
	public static boolean register(Users user) {
		Connection conn = JDBCBase.getConnection();
		String sql = "insert into users values(?,?)";
		PreparedStatement ps = null;	
		try {
			ps=conn.prepareCall(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			int num = ps.executeUpdate();
			if(num>0) {
				loger.debug("注册成功");
				return true;
			}else {
				loger.debug("这里不可能执行");
				return false;
			}
		} catch (SQLException e) {
			loger.debug("用户名重复");
		} 
		finally {
			closeAll(conn,ps,null);
		}		
		return false;		
	}

	private static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
