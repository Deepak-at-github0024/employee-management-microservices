package com.example.EmployeeAPIGateway.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;


@Service
public class JwtService {

    String SECRET = "bXlzZWNyZXRrZXlteXNlY3JldGtleW15c2VjcmV0a2V5bXlzZWNyZXRrZXk=";

    public SecretKey getKey()
    {
        byte[] byetKeys = Decoders.BASE64.decode(SECRET);

        return Keys.hmacShaKeyFor(byetKeys) ;
    }


    public String extractUsername(String token) {
      return  extractClaims(token ,Claims ::getSubject);
    }

    public boolean isTokenValid(String token,String username)
    {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        return  extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token)
    {
       return extractClaims(token , Claims::getExpiration);
    }

    public <T>T extractClaims(String token , Function<Claims , T>resolver)
    {
        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String extractRole(String token) {
        return extractClaims(token ,claims -> claims.get("ROLE",String.class) );
    }
}
