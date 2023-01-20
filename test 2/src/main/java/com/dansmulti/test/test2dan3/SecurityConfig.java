package com.dansmulti.test.test2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.authorizeRequests()
                .antMatchers("/generateToken").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/jobs").permitAll()
                .antMatchers("/jobs/{id}").permitAll();


    }
}
