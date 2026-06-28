package com.example.EmployeeAPIGateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http)
    {
        return  http.csrf(cs->cs.disable())
                .formLogin(f->f.disable())
                .httpBasic(h->h.disable())
                .authorizeExchange(ex->ex
                        .pathMatchers("/auth/login").permitAll()
                       /* .pathMatchers("/update/updateUsername/**").hasAnyRole("USER","ADMIN")
                        .pathMatchers("/employee/createEmployee").hasRole("ADMIN")*/
                        .anyExchange().permitAll())
                .build();

    }



}
