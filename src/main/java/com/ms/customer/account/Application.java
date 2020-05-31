package com.ms.customer.account;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class Application {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
*/
}
