package com.zjtachao.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//redis操作
@SpringBootApplication
@RestController
public class StringRedisController {

	protected static Logger logger = LoggerFactory.getLogger(StringRedisController.class);
	
	@Autowired
	public StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	public ValueOperations<String, String> valOpsSter;
	
	
	@RequestMapping("set")
	public String setKeyAndValue(String key,String value){
		logger.debug("访问set:key={},value={}",key,value);  
		valOpsSter.set(key, value);
		return "Set ok";
	}
	
	@RequestMapping("get")
	public String getKey(String key){
		 logger.debug("访问get:key={}",key);  
		 return valOpsSter.get(key);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(StringRedisController.class, args);
	}
}
