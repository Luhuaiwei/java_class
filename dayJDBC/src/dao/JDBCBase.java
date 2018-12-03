package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class JDBCBase {
	private static Logger loger = Logger.getLogger(JDBCBase.class);
	private static String driver;
	private static String url;
	private static Properties p = new Properties();
	static{		
		InputStream is = null;
		try {
			is = new FileInputStream("db.properties");
			p.load(is);
			driver = p.getProperty("mysql_driver");
			url = p.getProperty("mysql_url");
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Connection getConnection() {	
		loger.debug("开始进行数据库连接");	
		Connection conn = null;
		//连接数据库
		try {
			long start = System.currentTimeMillis();
			conn = DriverManager.getConnection(url,p);
			long end = System.currentTimeMillis();
			loger.debug("数据库连接成功");
			loger.debug("用时："+(end-start)+"ms");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
