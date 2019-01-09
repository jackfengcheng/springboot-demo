package com.xwtech.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	
	@Bean
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig config = new JedisPoolConfig();
		return config;
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory  jedisConnectionFactory(JedisPoolConfig config){
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPoolConfig(config);
		return factory;
	}
	
	@Bean
	public RedisTemplate<String, Object> template(JedisConnectionFactory factory){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}
}
