package security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

// ... existing imports ...
import jakarta.annotation.PostConstruct;
// ... existing imports ...
import javax.crypto.SecretKey;
// ... rest of imports ...
// ... rest of code ...import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
// ... existing imports ...
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.HashMap;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    
    private SecretKey key;
    
    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ... existing code ...
    
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
                .signWith(key)
                .compact();
    }
    public boolean validateToken(String token, String subject) {
        final String username = extractUsername(token);
        return (username.equals(subject) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()           // Changed from parserBuilder()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
