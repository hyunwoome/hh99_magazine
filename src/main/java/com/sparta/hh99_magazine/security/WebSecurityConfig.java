package com.sparta.hh99_magazine.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                // 모든 요청 인증
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()

                // 로그인 허용
                .formLogin()
                .loginPage("/api/signin")
                .loginProcessingUrl("/api/signin")
                .defaultSuccessUrl("/")
                .failureUrl("/api/signinError")
                .permitAll()
                .and()
                // 로그아웃 허용
                .logout()
                .permitAll();
    }
}