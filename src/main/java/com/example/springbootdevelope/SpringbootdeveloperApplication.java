package com.example.springbootdevelope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //created_at와 updated_at 자동 업데이트
@SpringBootApplication
public class SpringbootdeveloperApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdeveloperApplication.class, args);
	}

}
