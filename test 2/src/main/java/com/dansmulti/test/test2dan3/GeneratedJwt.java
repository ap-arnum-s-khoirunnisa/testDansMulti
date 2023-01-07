package com.dansmulti.test.test2dan3;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

/**
 * @author Arnum Sari Khoirunnisa
 * @date 07/01/23
 */
@Service
public class GeneratedJwt {
    public String getStringJwt(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, "dansmulti")
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("dansmulti").parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
