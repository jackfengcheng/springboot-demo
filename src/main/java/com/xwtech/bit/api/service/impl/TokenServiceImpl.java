package com.xwtech.bit.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.xwtech.bit.api.dao.TokenRepository;
import com.xwtech.bit.api.pojo.Token;
import com.xwtech.bit.api.service.TokenService;

/**
 * JackFeng
 */
@Service
public class TokenServiceImpl implements TokenService{
	
	@Autowired
	private TokenRepository tokenRepository;
	
	/**
	 * 根据token获取token
	 */
	@Override
	public List<Token> getToken(String token) {
		
		
		Specification<Token> sf= new Specification<Token>() {

			@Override
			public Predicate toPredicate(Root<Token> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				list.add(cb.equal(root.get("accessToken"), token));
				Predicate[] arr = new Predicate[list.size()]; 
				return cb.and(list.toArray(arr));
			}
		};
		
		List<Token> lists = this.tokenRepository.findAll(sf);
		return lists;
	}

	/**
	 * 新增token
	 */
	@Override
	public void createToken(Token token) {
		this.tokenRepository.save(token);
	}

  
}
