package com.example.EmployeeAPIGateway.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private JwtService jwtService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain)
    {

        String path = exchange.getRequest()
                .getURI()
                .getPath();

        // LOGIN API SHOULD BYPASS JWT
        if(path.contains("/auth/login") || path.contains("/auth/updatePassword/*"))
        {
            return chain.filter(exchange);
        }
        if(path.contains("/employee/test-feign") || path.contains("/employee/getFinUser/*"))
        {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            throw new RuntimeException("Missing Token");
        }

        String token = authHeader.substring(7);

        String username = jwtService.extractUsername(token);

        System.out.println("Username is"+username);

        String role = jwtService.extractRole(token);


        if(path.contains("/employee/createEmployee")
                && !role.equals("ROLE_ADMIN"))
        {
            throw new RuntimeException("Access Denied");
        }

        if(path.contains("/update/updateUsername")
                && !(role.equals("ROLE_ADMIN")
                || role.equals("ROLE_USER")))
        {
            throw new RuntimeException("Access Denied");
        }

        System.out.println("Role is "+role);

        if(!jwtService.isTokenValid(token,username))
        {
            throw new RuntimeException("Invalid Token");
        }

        // SPRING SECURITY AUTH OBJECT
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        List.of(new SimpleGrantedAuthority(role))
                );

        // ADD CUSTOM HEADERS
        ServerHttpRequest modifiedRequest =
                exchange.getRequest()
                        .mutate()
                        .header("X-Authenticated-User",username)
                        .header("X-Authenticated-Role",role)
                        .build();

        return chain.filter(
                        exchange.mutate()
                                .request(modifiedRequest)
                                .build()
                )
                .contextWrite(
                        ReactiveSecurityContextHolder
                                .withAuthentication(authentication)
                );
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
