package pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import dao.JDBCBase;

public class MyPool implements DataSource{
	LinkedList<Connection> pool = new LinkedList<>();
		
	public MyPool() {
		super();
		for(int i=0;i<5;i++) {
			pool.addLast(new MyConnection(JDBCBase.getConnection(),pool));
		}
	}	
	public void getBcak(LinkedList<Connection> pool) {
		this.pool = pool;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("还有几个可用的连接对象："+pool.size());
		if(pool.isEmpty()) {
			pool.addLast(new MyConnection(JDBCBase.getConnection(),pool));			
		}
		Connection conn = pool.removeFirst();
		return conn;
	}
	
	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		return null;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
