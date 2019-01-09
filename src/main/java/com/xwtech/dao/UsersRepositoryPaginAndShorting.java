package com.xwtech.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.xwtech.pojo.Users;

public interface UsersRepositoryPaginAndShorting extends PagingAndSortingRepository<Users, Integer> {

}
