package com.xwtech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.xwtech.pojo.Users;

public interface UsersRepositorySpeciafication extends JpaSpecificationExecutor<Users> ,  JpaRepository<Users, Integer>{

}
