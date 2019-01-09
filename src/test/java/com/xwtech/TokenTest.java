package com.xwtech;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xwtech.bit.api.pojo.Token;
import com.xwtech.bit.api.service.TokenService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class TokenTest {
	
	@Autowired
	private TokenService tokenservice;
	
	/**
	 * 添加token测试
	 * @throws UnknownHostException
	 */
	@Test
	public void tokenSave() throws UnknownHostException{
		Token token = new Token();
		token.setClientType("IOS");
		token.setAccessToken(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		token.setCreatedTime(new Date());
		token.seteCode("123456789");
		token.setuCode("45678945UUS");
		token.setMemberId("31500126");
		InetAddress addr=InetAddress.getLocalHost();
		token.setClientIp(addr.getHostAddress().toString());
		tokenservice.createToken(token);
	}
	
	
	/**
	 * 根据token查询token是否存在
	 */
	@Test
	public void tokenFind(){
		List<Token> tokens = tokenservice.getToken("543C8F36D2614C7D99297811ACB050BB");
		for (Token token : tokens) {
			System.out.println(token);
		}
	}
}
