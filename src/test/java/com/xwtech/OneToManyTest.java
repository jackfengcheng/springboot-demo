package com.xwtech;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xwtech.dao.UsersRepository;
import com.xwtech.pojo.Roles;
import com.xwtech.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToManyTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	/**
	 * 一对多的添加
	 */
	@Test
	public void oneToManySaveTest(){
		//创建用户
		Users users = new Users();
		users.setAddress("北京市安庆区");
		users.setAge(38);
		users.setName("刘能");
		
		//创建角色
		Roles roles= new Roles();
		roles.setRolename("管理员");
		
		//关联
		roles.getUsers().add(users);
		users.setRoles(roles);
		
		//保存
		this.usersRepository.save(users); 
	}

	/**
	 * 一对多的查询
	 */
	@Test
	public void oneToManyFindTest(){
		Users findOne = this.usersRepository.findOne(10);
		System.out.println(findOne);
		Roles roles = findOne.getRoles();
		System.out.println(roles.getRolename());
	}
}
