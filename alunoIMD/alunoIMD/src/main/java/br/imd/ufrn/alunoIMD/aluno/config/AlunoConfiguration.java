package br.imd.ufrn.alunoIMD.aluno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfiguration {

    @Bean(name = "aplicationName")
    public String aplicationName() {
        return "AlunoIMD";
    }



}
