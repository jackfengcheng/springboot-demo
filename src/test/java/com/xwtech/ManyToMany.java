package com.xwtech;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xwtech.dao.RolesRepository;
import com.xwtech.pojo.Menus;
import com.xwtech.pojo.Roles;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class ManyToMany {
	
	@Autowired
	private RolesRepository rolesRepository;
	/**
	 * 多对多添加
	 */
	@Test
	public void saveTest(){
		//创建角色对象
		Roles roles = new Roles();
		roles.setRolename("经理");
		
		//创建菜单对象
		Menus menus = new Menus();
		menus.setMenusname("用户添加");
		menus.setFatherid(0);
		Menus menus2 = new Menus();
		menus2.setMenusname("角色添加");
		menus2.setFatherid(0);
		
		//关联
		roles.getMenus().add(menus);
		roles.getMenus().add(menus2);
		menus.getRoles().add(roles);
		menus2.getRoles().add(roles);
		
		//保存
		this.rolesRepository.save(roles);
	}
	
	/**
	 * 多对多查询
	 */
	@Test
	public void findTest(){
		Roles roles = this.rolesRepository.findOne(3);
		System.out.println(roles);
		Set<Menus> menus = roles.getMenus();
		for (Menus menus2 : menus) {
			System.out.println(menus2);
		}
	}
}
