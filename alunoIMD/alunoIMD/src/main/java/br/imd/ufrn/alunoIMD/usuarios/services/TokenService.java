package br.imd.ufrn.alunoIMD.usuarios.services;

import br.imd.ufrn.alunoIMD.usuarios.model.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private  String secret;

    //Metodo que gera o Token
    public String genereteToken(UsuarioEntity usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("AlunosIMD") //Aplicação que emitiu o tokem
                    .withSubject(usuario.getLogin())  //Usuario que vai receber o tokem
                    .withExpiresAt(getExpirationDate()) //Tempo de expiração do token
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token", exception);
        }
    }

    //Metodo que valida os tokens - A configuração esta no SecurityConfig
    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("AlunosIMD")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
           return "";
        }
    }

    //Metodo que captura o tempo do sistema e soma 2h nele
    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
