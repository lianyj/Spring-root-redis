package com.zjtachao.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zjtachao.domain.Person;
@SpringBootApplication
@RestController
public class ObjectRedisController {

	  protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);  
      
	    @Autowired
	    public PersonDao personDao;  
	      
	    @RequestMapping("/setPerson")  
	    public void set(String id,String name,Integer age){  
	        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);  
	        Person person=new Person(id,name,age);  
	        personDao.save(person);  
	    }  
	      
	    @RequestMapping("/getPerson")  
	    public Person getPerson(String id){  
	        return personDao.getPerson(id);  
	    }  
	      
	
	public static void main(String[] args) {
        SpringApplication.run(ObjectRedisController.class, args);
	}
}
