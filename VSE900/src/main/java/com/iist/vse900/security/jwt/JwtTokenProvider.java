package com.iist.vse900.security.jwt;

import com.iist.vse900.domain.dto.JwtDTO;
import com.iist.vse900.domain.model.Category;
import com.iist.vse900.service.CategoriesService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenProvider {

    @Autowired
    CategoriesService categoriesService;

    public Map<String, Object> getCategory() {
        List<Category> categories = categoriesService.getAll();
        Map<String, Object> categoriesMap = new HashMap<>();

        for (Category category : categories) {
            categoriesMap.put(category.getType(), category.getName());
        }
        return categoriesMap;
    }

    public String generateToken(JwtDTO jwtDTO) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtDTO.getJwtExpiration());

        return Jwts.builder()
                .setSubject(Long.toString(1))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS384, jwtDTO.getJwtSecret())
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("JWT_SECRET")
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey("JWT_SECRET").parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        } catch (SignatureException ex) {
            log.error("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted..");
        }
        return false;
    }
}
