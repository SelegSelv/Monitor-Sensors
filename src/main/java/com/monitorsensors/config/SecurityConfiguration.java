package com.monitorsensors.config;


import com.monitorsensors.entity.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAspectJAutoProxy
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests( urlConfig -> urlConfig
                        .antMatchers("/resources/main1.css").permitAll()
                        .antMatchers(HttpMethod.GET,"/api/sensors").permitAll()
                        .antMatchers(HttpMethod.GET,"/api/sensors/**").permitAll()
                        .antMatchers(HttpMethod.POST,"/api/sensors").permitAll()
                        .antMatchers(HttpMethod.PUT,"/api/sensors").permitAll()
                        .antMatchers(HttpMethod.DELETE,"/api/sensors/**").permitAll()
                        .antMatchers("/updateSensor**","/deleteSensor**").hasAuthority(Role.Administrator.getAuthority())
                        .anyRequest().authenticated()
                )
                .logout(logout-> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID"))
                .formLogin(login->login
                        .loginPage("/login")
                        .failureUrl("/login?err=true")
                        .defaultSuccessUrl("/main")
                        .permitAll());
    }



}

