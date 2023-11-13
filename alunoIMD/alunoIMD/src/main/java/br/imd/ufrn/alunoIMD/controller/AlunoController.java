package br.imd.ufrn.alunoIMD.controller;

import br.imd.ufrn.alunoIMD.model.DadosAluno;
import br.imd.ufrn.alunoIMD.model.DadosAtualizarAluno;
import br.imd.ufrn.alunoIMD.services.AlunoService;
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
    public void cadastrar(@RequestBody @Valid DadosAluno dados){
        alunoService.cadastrarAluno(dados);
    }

    @GetMapping
    public List<DadosAluno> listar(){
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
