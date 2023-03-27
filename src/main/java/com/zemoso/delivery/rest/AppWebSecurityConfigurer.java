package com.zemoso.delivery.rest;

//import java.util.Arrays;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppWebSecurityConfigurer extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception {    
        http.cors().and()
        .csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
        //.csrf().ignoringAntMatchers("/sarcrm/**")
       // .and()
        //.authorizeRequests()
         //  .antMatchers("/sarcrm/**").permitAll();
         //   .csrf().disable()
         //   .authorizeRequests()
         //       .anyRequest().permitAll();
        }
}