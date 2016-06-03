package com.aricent.eip.itsm;


import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackageClasses=ITSM.class)
public class Application {
//
//	 @Autowired
//     EntityManager entityManager;
	 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

       public static void main(String[] args) {
    	   //Check merge
              SpringApplication.run(Application.class, args);
       }
       
      

       @Bean  
       public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
    	   System.out.println("I am here in sessionfactory");
    	   System.out.println(hemf);
    	   System.out.println("sessionfactory bean is "+hemf.getSessionFactory());
           return hemf.getSessionFactory();  
       }  	
       
            
       
}

