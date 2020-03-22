package com.mw.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // .antMatchers("/").permitAll()  // allow public access to home page
            .antMatchers("/").hasRole("EMPLOYEE")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
            .and()
                .logout().permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
