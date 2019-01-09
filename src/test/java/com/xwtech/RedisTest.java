package com.xwtech;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import com.xwtech.pojo.Userss;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void setStringToRedis(){
		this.redisTemplate.opsForValue().set("string", "这是一个美好的事情");
		System.out.println("存储成功");
	}
	
	@Test
	public void getStringToRedis(){
		String str = (String)this.redisTemplate.opsForValue().get("string");
		System.out.println("获取成功"+str);
	}
	
	/**
	 * 添加一个实体
	 */
	@Test
	public void setUserToRdis(){
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Userss user = new Userss();
		user.setName("张三");
		user.setAge(18);
		user.setPassword(123+"");
		user.setEmail("531739331@qq.com");
		this.redisTemplate.opsForValue().set("users", user);
	}
	/**
	 * 获取一个实体
	 */
	@Test
	public void getUserToRedis(){
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Userss user = (Userss)this.redisTemplate.opsForValue().get("users");
		System.out.println("---------------->"+user);
	}
	
	/**
	 * 添加一个json格式的实体
	 */
	@Test
	public void setUserToRedisJson(){
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Userss.class));
		Userss user = new Userss();
		List<Userss> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			user.setName("张三");
			user.setAge(i);
			user.setPassword(123+"");
			user.setEmail("531739331@qq.com");
			list.add(user);
		}
		
		
		this.redisTemplate.opsForValue().set("users-json", list, 3000, TimeUnit.SECONDS);
	}
	

	/**
	 * 获取一个json格式的实体
	 */
	@Test
	public void getUserToRedisJson(){
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Userss.class));
		Userss user = (Userss)this.redisTemplate.opsForValue().get("users-json");
		System.out.println("userjson----------------->"+user);
	}
	
}
