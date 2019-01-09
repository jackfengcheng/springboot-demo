package com.xwtech.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.xwtech.pojo.Users;

public interface UsersRepositoryByName extends Repository<Users, Integer> {
	
	
	List<Users> findByName(String name);
	
	List<Users> findByNameAndAge(String name,Integer age);
	
	List<Users> findByNameLike(String name);
}
