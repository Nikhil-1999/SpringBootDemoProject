package org.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

/*
@SpringBootConfiguration
This annotation is a specialized form of the @Configuration annotation in Spring Boot.
It is used to indicate that a class provides configuration for a Spring Boot application.
*/

/*
@EnableAutoConfiguration
This annotation is a key annotation in Spring Boot that automatically configures the Spring
application context based on the project's dependencies and the classpath.
*/

/*
@ComponentScan
This annotation is used in Spring to specify the base packages for Spring component scanning.
Component scanning is the process by which Spring finds and registers beans
(components, services, repositories, etc.) in your application context automatically.
*/

/*
@SpringBootApplication
This annotation is a meta-annotation in Spring Boot, combining above three annotations to simplify the configuration of Spring applications.
It is often used at the entry point of a Spring Boot application. By using @SpringBootApplication, you're essentially configuring your Spring Boot application
with sensible defaults, enabling autoconfiguration, and specifying the base package for component scanning.
 */