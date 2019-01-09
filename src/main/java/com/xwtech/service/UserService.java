package com.xwtech.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xwtech.pojo.Users;

public interface UserService {
	

	List<Users> findUserAll();
	Users findUserById(Integer id);
	Page<Users> findUserByPage(Pageable pageable);
	void saveUsers(Users user);
}
