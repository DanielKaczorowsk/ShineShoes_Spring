package Builders.UserBuilder.Login;

import DTO.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
public class GenerateToken implements LoginBuilderInterface
{
    private static final String SECRET_STRING = "twoj_bardzo_dlugi_klucz_ktory_ma_minimum_32_znaki_!!!";
    private final Key key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes());
    @Override
    public void build(UserDTO query)
    {
        String token = Jwts.builder()
                .subject(query.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
        query.setToken(token);
    }
}
