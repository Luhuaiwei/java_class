package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class JDBCUtil {
	private static DruidDataSource ds = new DruidDataSource();
	static{		
		Properties p = new Properties();		
		try {
			p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("dbDruidConfig.properties"));
			ds.setDriverClassName(p.getProperty("driverClassName"));
			ds.setUrl(p.getProperty("url"));
			ds.setUsername(p.getProperty("username"));
			ds.setPassword(p.getProperty("password"));
			ds.setMaxActive(Integer.parseInt(p.getProperty("maxActive")));	
			System.out.println("内部初始化连接");
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} 	
	}
	
	public static Connection getConnection() {
		Connection conn = null;		
		try {
			conn = ds.getConnection();
			System.out.println("获得连接对象");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;		
	}
	
	public static DruidDataSource getDataSource() {
		return ds;
		
	}
	
}
