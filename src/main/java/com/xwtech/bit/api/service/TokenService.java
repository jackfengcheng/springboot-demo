package com.xwtech.bit.api.service;

import java.util.List;

import com.xwtech.bit.api.pojo.Token;

/**
 * JackFeng
 */
public interface TokenService {

	 void createToken(Token token);

     List<Token> getToken(String token);
}
