package com.mw.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       User.UserBuilder users = User.withDefaultPasswordEncoder();

       auth.inMemoryAuthentication()
           .withUser(users.username("employee").password("test").roles("EMPLOYEE"))
           .withUser(users.username("manager").password("test").roles("MANAGER"))
           .withUser(users.username("admin").password("test").roles("ADMIN"));

    }
}
