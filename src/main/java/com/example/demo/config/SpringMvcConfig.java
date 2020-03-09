package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


 // this class doesn't run during testing
@Configuration
public class SpringMvcConfig {

    @Bean
    public RestTemplate rest_template(){
        return new RestTemplate();
    };

}
