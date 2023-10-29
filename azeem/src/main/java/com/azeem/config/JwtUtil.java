package com.azeem.config;

import com.azeem.entities.User;
import com.azeem.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Autowired
    private CustomUserDetailService userDetailService;


    public String getUsernameFromToken(String token) {
    return getClaimsFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimsFromToken(String token, Function<Claims, T> claimResolver) {
        final Claims claims =  getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JwtService.key).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token, UserDetails user){
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        final Date expirationDate  = getExpirationDateFromToken(token);
        return expirationDate.after(new Date());

    }


    public Date getExpirationDateFromToken(String token){
        return getClaimsFromToken(token , Claims::getExpiration);
    }

}
