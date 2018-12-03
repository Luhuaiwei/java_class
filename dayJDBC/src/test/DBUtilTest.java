package test;

import org.junit.jupiter.api.Test;

import entity.Users;
import service.DBUtil;

class DBUtilTest {
	Users user = new Users();
	@Test
	void testModifyPasswd() {
		boolean flag = true;
		if(flag) {
			user.setUsername("卢怀伟");
			user.setPassword("secret.222.lhw");
		}else {
			user.setUsername("不存在的");
			user.setPassword("secret.222.lhw");
		}
		boolean result = DBUtil.modifyPasswd(user);
		System.out.println("修改密码操作执行成功了吗："+result);
	}
	
	@Test
	void testLogin() {
		boolean flag = true;
		if(flag) {
			user.setUsername("卢怀伟");
			user.setPassword("secret.222.lhw");
		}else {
			user.setUsername("不存在的");
			user.setPassword("secret.222.lhw");
		}
		boolean result = DBUtil.login(user);
		System.out.println("登录操作执行成功了吗："+result);
	}

	@Test
	void testRegister() {
		boolean flag = true;
		if(flag) {
			user.setUsername("卢"+System.currentTimeMillis());
			user.setPassword("secret.222.lhw");
		}else {
			user.setUsername("卢怀伟");
			user.setPassword("secret.222.lhw");
		}
		boolean result = DBUtil.register(user);
		System.out.println("注册操作执行成功了吗："+result);
	}

}
