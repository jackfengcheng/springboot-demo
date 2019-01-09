package com.xwtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xwtech.bit.api.core.ApiGatewayHand;

@SpringBootApplication
@ServletComponentScan
//@EnableCaching
//@EnableScheduling
@Configuration
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public ApiGatewayHand apiGatewayHand(){
		return new ApiGatewayHand();
	}
}
