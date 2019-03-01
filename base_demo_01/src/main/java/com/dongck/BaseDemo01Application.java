package com.dongck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.dongck.dao.service")
@EntityScan(basePackages="com.dongck.pojo")
public class BaseDemo01Application {

	public static void main(String[] args) {
		SpringApplication.run(BaseDemo01Application.class, args);
	}

}
