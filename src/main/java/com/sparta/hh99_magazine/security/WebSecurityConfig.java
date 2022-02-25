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
                    .antMatchers("/api/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                // TODO: 로그인이 계속 진행되는 경우 (계속 세션 발급됨)
                .formLogin()
                    .loginPage("/api/signin")
                    .loginProcessingUrl("/api/signin")
                    .defaultSuccessUrl("/")
                    .failureUrl("/api/signinError")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/api/signoutSuccess")
                    .invalidateHttpSession(true) // 선택
                    .deleteCookies("JSESSIONID") // 선택
                    .permitAll();
    }
}