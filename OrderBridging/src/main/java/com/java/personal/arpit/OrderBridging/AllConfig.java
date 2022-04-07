package com.java.personal.arpit.OrderBridging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllConfig 
{

	@Bean
	public JmsQueueTopic objJmsQueueTopic(){
		return new JmsQueueTopic();
	}
	
	@Bean
	public JsonObjectImpl objJsonObjectImpl(){
		return new JsonObjectImpl();
	}
	
	
	
	@Bean
	public JsonParsing objJsonParsing(){
		return new JsonParsing();
	}
}
