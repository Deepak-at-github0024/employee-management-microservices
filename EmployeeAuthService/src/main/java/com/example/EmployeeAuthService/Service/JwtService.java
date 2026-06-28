package com.example.EmployeeAuthService.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtService {

    @Autowired
            private MyUserDetailsService service ;


    String SECRET = "bXlzZWNyZXRrZXlteXNlY3JldGtleW15c2VjcmV0a2V5bXlzZWNyZXRrZXk=";

    public SecretKey getKey()
    {
        byte[] byetKeys = Decoders.BASE64.decode(SECRET);

        return Keys.hmacShaKeyFor(byetKeys) ;
    }


    public String generateToken(String username) {

        UserDetails userDetails = service.loadUserByUsername(username);
        String role = userDetails.getAuthorities()
                .stream().findFirst().get().getAuthority();

        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE",role);

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .signWith(getKey())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+10*10*60*60*10))
                .compact();
    }
}
