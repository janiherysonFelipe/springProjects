package br.imd.ufrn.alunoIMD.usuarios.controller;

import br.imd.ufrn.alunoIMD.usuarios.model.AutenticationDTO;
import br.imd.ufrn.alunoIMD.usuarios.model.LoginResponseDTO;
import br.imd.ufrn.alunoIMD.usuarios.model.RegistrarDTO;
import br.imd.ufrn.alunoIMD.usuarios.model.UsuarioEntity;
import br.imd.ufrn.alunoIMD.usuarios.repository.UsuarioRepository;
import br.imd.ufrn.alunoIMD.usuarios.services.TokenService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticationController {


    // Injeção de dependencia que permite a gestão da autenticação
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;


    //Esse metodo recebe um login e senha e chama o metodo que realiza a autenticação no Spring
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticationDTO data){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usuarioSenha);
        var token = tokenService.genereteToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    //Metodo que tem como objetivo registrar um novo usuario para acesso ao sistema
    @PostMapping("/registrar")
    public ResponseEntity registrarUsuario(@RequestBody @Valid RegistrarDTO data){
        if(repository.findByLogin(data.login()) != null) { //Se houver no banco reorna um badrequest
            return ResponseEntity.badRequest().build();
        }else{
            String senhaEncriptada = new BCryptPasswordEncoder().encode(data.password()); //Encripta a senha
            UsuarioEntity usuario = new UsuarioEntity(data.login(), senhaEncriptada, data.role());
            this.repository.save(usuario); //Salva no banco
            return ResponseEntity.noContent().build(); //Retorna a resposta correta
        }

    }
}
