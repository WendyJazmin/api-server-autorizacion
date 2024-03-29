package com.example.demo.security;



import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwUtils {

	@Value("${app.jwtSemilla}")
	private String jwtSemilla;
	
	@Value("${app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String buildTokenJwt(String nombre) {
		return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() /*+this.jwtExpirationMs*/+ 100000000))
				.signWith(SignatureAlgorithm.HS512, "fckmsdmfmisofsfosofifisdefikiregi9483r84ruff8ufru87rg8ww322rrrrfsemillawdefrfgdtvgbomgobmdrb203290324825835824202405385358035edscfsdfsdfds3053035")
				.compact();//setSubject se pude oner varias veces y enviar lo que queramos
		
	}
}
