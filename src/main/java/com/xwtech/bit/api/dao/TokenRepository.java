package com.xwtech.bit.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.xwtech.bit.api.pojo.Token;

@Repository
public interface TokenRepository extends JpaSpecificationExecutor<Token>,JpaRepository<Token, Long>{

}
