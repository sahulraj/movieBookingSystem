package com.example.movieBookingSystem.Configure;

import com.example.movieBookingSystem.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
    {
//        return http.csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(auth->
//                        auth.requestMatchers("/user").hasAnyRole("ADMIN","USER")
//                                .requestMatchers("/admin").hasRole("ADMIN")
//                                .requestMatchers("/login", "/register","/role").permitAll().anyRequest().authenticated())
//
//                .httpBasic(Customizer.withDefaults())
//                .build();
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/login", "/register", "/role","http://localhost:8080/swagger-ui/index.html").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}