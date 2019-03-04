package com.dongck;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.dongck.dao.service")
@EntityScan(basePackages="com.dongck.pojo")
public class BaseDemo01Application {
	
	@Autowired
	private RedisTemplate redisTemplate = null;
	
	@PostConstruct
	public void init(){
		initRedisTemplate();
	}
	
	private void initRedisTemplate() {
		RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
		redisTemplate.setStringSerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
	}

	public static void main(String[] args) {
		SpringApplication.run(BaseDemo01Application.class, args);
	}

	
	
}
