package com.example.demo.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf(csrf -> {
            CookieCsrfTokenRepository cookieCsrfTokenRepository= new CookieCsrfTokenRepository();
            cookieCsrfTokenRepository.setCookieName("XSRF-TOKEN");
            cookieCsrfTokenRepository.setHeaderName("x-xsrf-token");
            cookieCsrfTokenRepository.setCookieHttpOnly(false);
            csrf.csrfTokenRepository(cookieCsrfTokenRepository);
        });
    }
}
