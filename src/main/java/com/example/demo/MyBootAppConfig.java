package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBootAppConfig {

	@Bean
	MyDataBean myDataBean(){
		return new MyDataBean();
	}
	
	@Bean
	MyTLDialect myTLDialect(){
	    return new MyTLDialect();
	}
}
