package br.imd.ufrn.alunoIMD.aluno.controller;

import br.imd.ufrn.alunoIMD.aluno.model.AlunoEntity;
import br.imd.ufrn.alunoIMD.aluno.model.DadosAtualizarAluno;
import br.imd.ufrn.alunoIMD.aluno.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/alunos" , "/estudantes"} )
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid AlunoEntity dados){

        alunoService.cadastrarAluno(dados);
    }

    @GetMapping
    public List<AlunoEntity> listar(){
        return alunoService.listarAlunos();
    }

    @PutMapping
    public void atualizarAluno(@RequestBody @Valid DadosAtualizarAluno dados){
       alunoService.atualizarAluno(dados);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable long id){
       alunoService.deletarAluno(id);
    }

    @DeleteMapping("/inativar/{id}")
    public void inativar(@PathVariable long id){
        alunoService.inativar(id);
    }

    @GetMapping("/hello")
    public String aplicationName(){
      return alunoService.aplicationName();
    }
}
