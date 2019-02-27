package com.dongck.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.dongck.*")
@PropertySource(value={"classpath:myProper.properties"}, ignoreResourceNotFound=true)
public class MyConfig {

}
