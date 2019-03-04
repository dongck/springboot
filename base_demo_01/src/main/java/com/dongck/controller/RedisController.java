package com.dongck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	@RequestMapping("/getByKey")
	public String redisTest(@RequestParam(name="key") String key){
		String val = redisTemplate.opsForValue().get(key);
		return val;
	}

}
