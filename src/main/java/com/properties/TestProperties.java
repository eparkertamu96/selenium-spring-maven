package com.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:test.properties")
public class TestProperties {

	@Value("${baseUrl}")
	public String baseUrl;	
}
