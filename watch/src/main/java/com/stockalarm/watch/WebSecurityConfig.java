//package com.stockalarm.watch;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//    http
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
//            .authorizeRequests()
//            .antMatchers(SecurityParams.PUBLIC_ROUTES).permitAll()
//            .antMatchers("/socket/**").permitAll();
//
//    http.csrf().disable();
//}}
