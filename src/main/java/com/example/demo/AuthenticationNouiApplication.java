package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class AuthenticationNouiApplication extends SpringBootServletInitializer{

	private static Class AuthenticationNouiApplication = AuthenticationNouiApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationNouiApplication.class, args);
    }
    @Bean 
    ServletWebServerFactory servletWebServerFactory(){
    return new TomcatServletWebServerFactory();
    }

}
