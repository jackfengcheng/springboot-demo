package com.xwtech.exception;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class GlobalException {
	/**
	 * 该方法的返回值必须是 SimpleMappingExceptionResolver
	 */
	@Bean
	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		
		Properties mappings = new Properties();
		/**
		 * 参数一表示异常的类型
		 * 参数二表述，产生异常需要跳转的视图的名称
		 * 异常的集中处理，但是无法返回具体的异常信息
		 */
		mappings.put("java.lang.NullPointerException", "nullPointerException");
		mappings.put("java.lang.ArithmeticException", "arithmeticException");
		resolver.setExceptionMappings(mappings);
		return resolver;
	}
	
}
