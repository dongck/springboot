package com.dongck.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ComponentScan(basePackages="com.dongck.*")
@PropertySource(value={"classpath:application.properties","classpath:myProper.properties"}, ignoreResourceNotFound=true)
@ImportResource(value="classpath:spring-other.xml")
public class MyConfig {

}
