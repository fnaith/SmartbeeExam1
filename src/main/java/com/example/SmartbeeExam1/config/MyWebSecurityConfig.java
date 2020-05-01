package com.example.SmartbeeExam1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("deprecation")
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("super").password("super").roles("SUPER")
                .and()
                .withUser("manager").password("manager").roles("MANAGER")
                .and()
                .withUser("operator").password("operator").roles("OPERATOR");
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/super/**").hasRole("SUPER")
                .antMatchers("/manager/**").access("hasAnyRole('SUPER','MANAGER')")
                .antMatchers("/operator/**").access("hasAnyRole('SUPER','OPERATOR')")

                .antMatchers(HttpMethod.GET, "/company").access("hasAnyRole('SUPER','MANAGER','OPERATOR')")
                .antMatchers(HttpMethod.POST, "/company").access("hasAnyRole('SUPER','OPERATOR')")
                .antMatchers(HttpMethod.DELETE, "/company/**").access("hasAnyRole('SUPER','MANAGER')")
                .antMatchers(HttpMethod.GET, "/company/**").access("hasAnyRole('SUPER','MANAGER','OPERATOR')")
                .antMatchers(HttpMethod.PUT, "/company/**").access("hasAnyRole('SUPER','MANAGER')")

                .antMatchers(HttpMethod.GET, "/client").access("hasAnyRole('SUPER','MANAGER','OPERATOR')")
                .antMatchers(HttpMethod.POST, "/client").access("hasAnyRole('SUPER','OPERATOR')")
                .antMatchers(HttpMethod.DELETE, "/client/**").access("hasAnyRole('SUPER','MANAGER')")
                .antMatchers(HttpMethod.GET, "/client/**").access("hasAnyRole('SUPER','MANAGER','OPERATOR')")
                .antMatchers(HttpMethod.PUT, "/client/**").access("hasAnyRole('SUPER','MANAGER')")

                .anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/login").permitAll()
                .and().csrf().disable();
    }
}
