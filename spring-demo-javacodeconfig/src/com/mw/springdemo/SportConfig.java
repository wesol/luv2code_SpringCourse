package com.mw.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    @Scope("singleton")
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    public FortuneService new7FortuneService(){
        return new New7FortuneService();
    }

    @Bean
    public Coach new7Coach() {
        return new New7Coach(new7FortuneService());
    }
}
