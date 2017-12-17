package org.sysmaco.spring.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 *	SpringBootServletInitializer 
 *	Enable process used in servlet 3.0 using web.xml
 *  And configure the class as Spring boot application
 *  @SpringBootApplication :- 
 *  	Equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:
 *
 */
@SpringBootApplication
public class ApplicationConfig extends SpringBootServletInitializer 
{
	 private static Class<ApplicationConfig> applicationClass = ApplicationConfig.class;

	    public static void main(String[] args) {
	    	// SpringApplication take the command argument and name of the class that extends the spring boot
	        SpringApplication.run(ApplicationConfig.class, args);
	    }

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
}
