package com.xwtech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xwtech.bit.api.core.APIMapping;
import com.xwtech.dao.UsersRepository;
import com.xwtech.pojo.Users;
import com.xwtech.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@APIMapping(value = "bit.api.findUserAll")
	public List<Users> findUserAll() {
		return this.usersRepository.findAll();
	}

	@Override
	@APIMapping(value = "bit.api.findUserById")
	public Users findUserById(Integer id) {
		return this.usersRepository.findOne(id);
	}

	@Override
	public Page<Users> findUserByPage(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}

	@Override
	public void saveUsers(Users user) {
		this.usersRepository.save(user);
	}

}
