package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import entity.Users;
import service.usersCURD;

class userCURDTest {
	Users user = new Users();

	@BeforeEach
	void before() {
		System.out.println("单个执行会用到这哥们吗");
		user.setPassword("secret.222.lhw");
	}
	
	@BeforeAll
	public static void beforeclass() {
		System.out.println("哪个县？");
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
		boolean result = usersCURD.login(user);
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
		boolean result = usersCURD.register(user);
		System.out.println("注册操作执行成功了吗："+result);
	}

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
		boolean result = usersCURD.modifyPasswd(user);
		System.out.println("修改密码操作执行成功了吗："+result);
	}
}
