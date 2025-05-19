package yjcho.ezgraph.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JWTProvider {

    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;

    public String getTokenType(String token) {
        Jwt jwt = jwtDecoder.decode(token);
        if(!jwt.hasClaim("type"))
            throw new InvalidBearerTokenException("Missing claim \"type\"");
        return jwt.getClaim("type");
    }

    public String createToken(Authentication auth) {
        Instant now = Instant.now();
        long expiresIn = 24; // 24hours

        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(expiresIn, ChronoUnit.HOURS))
                .subject(auth.getName())
                .claim("authorities", authorities)
                .claim("type", "access")
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

    }
}
