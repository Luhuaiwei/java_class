package entity;
/**
 * 用于数据库映射
 * @author Administrator
 *
 */
public class User {
	private String usname;
	private String passwd;
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User() {
		super();
	}
	public String toString() {
		return usname+":"+passwd;
	}
	
	
}
