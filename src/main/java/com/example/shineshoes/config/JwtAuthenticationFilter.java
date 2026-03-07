package com.example.shineshoes.core.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    private final String secret;
    public JwtAuthenticationFilter(@Value("${jwt.secret}") String secret)
    {
        this.secret = secret;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer"))
        {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try
        {
            Claims claims = Jwts.parser().verifyWith(Keys
                    .hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String username = claims.getSubject();
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username, null, new ArrayList<>()
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error verify token:"+ e.getMessage());
        }
        filterChain.doFilter(request, response);
    }

}
