// package br.edu.ifsul.sapucaia.lp.security;

// import static java.util.Optional.empty;
// import static java.util.Optional.ofNullable;
// import java.util.Date;
// import java.util.Optional;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jws;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;
// @Component
// public class JwtTokenProvider {

//     @Value("${security.jwt.secret}")
//     private String jwtSecret;

//     @Value("${security.jwt.expiration}")
//     private int jwtExpiration;

//     // cria token a partir de um usuário autenticado
//     public String generateToken(Authentication authentication) {

//         UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

//         Date now = new Date();
//         Date expiryDate = new Date(new Date().getTime() + jwtExpiration);

//         return Jwts.builder()
//             .setSubject(userPrincipal.getUsername())
//             .setIssuedAt(now)
//             .setExpiration(expiryDate)
//             .signWith(SignatureAlgorithm.HS512, jwtSecret)

//             //  .claim("id", userPrincipal.getId())
//                 .claim("username",userPrincipal.getUsername())
//             .compact();
//     }

//     // obtém id do usuário a partir de um token
//     public Optional<String> getUsername(String jwt) {
//         try {
//             Claims claims = parse(jwt).getBody();

//             // claims.get(key, class)

//             return ofNullable(claims.getSubject());
//         } catch (Exception ex) {
//             return empty();
//         }
//     }

//     private Jws<Claims> parse(String jwt) {
//         return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt);
//     }
// }
