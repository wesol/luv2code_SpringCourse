package com.mw.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mw.springdemo")
public class SportConfigWithComponentScan {

    @Bean
    public Coach tennisCoach() {
        return new TennisCoach();
    }
}
