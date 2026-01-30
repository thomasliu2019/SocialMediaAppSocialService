package com.example.socialProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SocialProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialProfileApplication.class, args);
	}

}
