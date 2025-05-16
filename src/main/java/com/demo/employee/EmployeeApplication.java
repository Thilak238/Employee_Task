package com.demo.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
//@Configuration (indicates that it is source of bean definitions >> @Bean is used to say that this class is spring container bean by creating 
//constructor to it) 
//+ @EnableAutoConfiguration (It examines classPath for relevant dependencies & automatically configures beans based on these dependencies) 
//+ @ComponentScan (It tells spring to look for classes annotated with @Component , @Service, @Reponsitory, @Controller)
//Purpose of @Component >> Automatically instantiates them as beans within application context >> Injected beans can be injected @Autowired
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
