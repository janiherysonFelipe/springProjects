package br.imd.ufrn.alunoIMD.controller;

import br.imd.ufrn.alunoIMD.model.DadosAluno;
import br.imd.ufrn.alunoIMD.model.DadosAtualizarAluno;
import br.imd.ufrn.alunoIMD.model.alunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class alunoController {

    @Autowired
    alunoRepository repository;

    @PostMapping
    @Transactional //Dá um Roll back no banco caso seja feita a operação incompleta
    public void cadastrar(@RequestBody @Valid DadosAluno dados){
        repository.save(new DadosAluno(dados));
    }

    @GetMapping
    public List<DadosAluno> listar(){
        return repository.findAllByAtivoTrue();
    }

    @PutMapping
    @Transactional //Dá um Roll back no banco caso seja feita a operação incompleta
    public void atualizarAluno(@RequestBody @Valid DadosAtualizarAluno dados){
        DadosAluno aluno = repository.getReferenceById(dados.id());
        aluno.atualizarAluno(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarAluno(@PathVariable long id){
        repository.deleteById(id);
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public void inativar(@PathVariable long id){
        DadosAluno aluno = repository.getReferenceById(id);
        aluno.inativar();

    }
}
