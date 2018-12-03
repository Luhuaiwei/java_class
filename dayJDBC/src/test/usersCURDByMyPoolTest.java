package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Users;
import service.usersCURDByMyPool;


class usersCURDByMyPoolTest {
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
		boolean result = usersCURDByMyPool.modifyPasswd(user);
		System.out.println("修改密码操作执行成功了吗："+result);
	}

	@Test
	void testLogin() {
		boolean flag = false;
		if(flag) {
			user.setUsername("卢怀伟");
			user.setPassword("secret.222.lhw");
		}else {
			user.setUsername("不存在的");
			user.setPassword("secret.222.lhw");
		}
		boolean result = usersCURDByMyPool.login(user);
		System.out.println("登录操作执行成功了吗："+result);
	}

	@Test
	void testRegister() {
		boolean flag = false;
		if(flag) {
			user.setUsername("卢"+System.currentTimeMillis());
			user.setPassword("secret.222.lhw");
		}else {
			user.setUsername("卢怀伟");
			user.setPassword("secret.222.lhw");
		}
		boolean result = usersCURDByMyPool.register(user);
		System.out.println("注册操作执行成功了吗："+result);
	}

}
