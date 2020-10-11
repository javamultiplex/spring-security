package com.javamultiplex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.javamultiplex.security.ApplicationUserRole.ADMIN;
import static com.javamultiplex.security.ApplicationUserRole.STUDENT;

/**
 * @author Rohit Agarwal on 03/10/20 4:37 pm
 * @copyright www.javamultiplex.com
 */

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails rohitUser = User
                .builder()
                .username("Rohit")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())//ROLE_STUDENT
                .build();
        UserDetails bhavnaUser = User
                .builder()
                .username("Bhavna")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())//ROLE_ADMIN
                .build();
        return new InMemoryUserDetailsManager(rohitUser, bhavnaUser);
    }
}
