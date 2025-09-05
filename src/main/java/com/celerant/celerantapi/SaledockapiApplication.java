package com.celerant.celerantapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//TODO : currently disabling the security
@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class SaledockapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaledockapiApplication.class, args);
    }

}
