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

import static com.javamultiplex.security.ApplicationUserRole.*;

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
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails rohit = User
                .builder()
                .username("Rohit")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())//ROLE_STUDENT
                .build();
        UserDetails bhavna = User
                .builder()
                .username("Bhavna")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())//ROLE_ADMIN
                .build();
        UserDetails shivani = User
                .builder()
                .username("Shivani")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN_TRAINEE.name())//ROLE_ADMIN_TRAINEE
                .build();
        return new InMemoryUserDetailsManager(rohit,
                bhavna,
                shivani);
    }
}
