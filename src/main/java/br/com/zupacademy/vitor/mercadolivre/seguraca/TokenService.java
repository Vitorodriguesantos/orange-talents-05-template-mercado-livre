package br.com.zupacademy.vitor.mercadolivre.seguraca;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.zupacademy.vitor.mercadolivre.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenService {
	
	@Value("${mercado-livre.jwt.expiration}")
	private String expiracao;
	
	@Value("${mercado-livre.jwt.secret}")
	private String segredo;

	public String gerarToken(Authentication authentication) {
		
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		System.out.println("USUARIO LOGADO ---> "+usuarioLogado);
		Date hoje = new Date();
		Date expira = new Date(hoje.getTime()+Long.parseLong(expiracao));
		
		return Jwts.builder()
				.setIssuer("API MERCADO LIVRE")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(expira)
				.signWith(SignatureAlgorithm.HS256, segredo)
				.compact();
	}

	public boolean verificaTokenValido(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.segredo).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.segredo).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
