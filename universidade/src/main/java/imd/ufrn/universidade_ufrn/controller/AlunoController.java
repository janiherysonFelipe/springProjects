package imd.ufrn.universidade_ufrn.controller;


import imd.ufrn.universidade_ufrn.DTO.AtualizarAlunoDTO;
import imd.ufrn.universidade_ufrn.model.Aluno;
import imd.ufrn.universidade_ufrn.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/alunos" , "/aluno"})
public class AlunoController {

    @Autowired
    AlunoService aluno;

    @PostMapping
    public void cadastrar(@RequestBody @Valid Aluno dados){
        aluno.cadastrarAluno(dados);
    }

    @GetMapping
    public List<Aluno> listar(){
        return aluno.listarAlunos();
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        aluno.deletarAluno(id);
    }

    @PutMapping
    public void atualizarAluno(@RequestBody @Valid AtualizarAlunoDTO dados){
        aluno.atualizarAluno(dados);
    }
}
