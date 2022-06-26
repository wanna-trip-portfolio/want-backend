package com.want.want;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WantApplication {

	public static void main(String[] args) {
		SpringApplication.run(WantApplication.class, args);
	}

}
