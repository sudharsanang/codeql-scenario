import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthApplication {

    private static final String JWT_SECRET = "HardcodedJWTSecret123";

    public static void main(String[] args) throws Exception {

        String token = Jwts.builder()
                .setSubject("admin")
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();

        System.out.println(token);

        SpringApplication.run(AuthApplication.class, args);
    }
}
