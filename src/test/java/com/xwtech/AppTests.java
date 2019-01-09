package com.xwtech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xwtech.pojo.Users;
import com.xwtech.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class AppTests {
	
	@Autowired
	private UserService UserService;
	
	@Test
	public void findUserAll() {
		this.UserService.findUserAll();
	}
	@Test
	public void findUserById() {
		Users id = this.UserService.findUserById(1);
		System.out.println(id);
	}
	@Test
	public void saveUser() {
		Users user = new Users();
		user.setName("王五");
		user.setAge(16);
		user.setAddress("兰州市安宁区北滨河路");
		this.UserService.saveUsers(user);
	}

}
