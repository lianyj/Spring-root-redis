package com.zjtachao.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HelloController {
	
	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
	public String helloword(){
		logger.debug("访问hello");
		return "Hello World";
	}
	
    @RequestMapping("/hello/{name}")  
    public String helloName(@PathVariable String name){  
        logger.debug("访问helloName,Name={}",name);  
        return "Hello "+name;  
    }  
	
	
	 public static void main(String[] args) {
	        SpringApplication.run(HelloController.class, args);
	    }
}
