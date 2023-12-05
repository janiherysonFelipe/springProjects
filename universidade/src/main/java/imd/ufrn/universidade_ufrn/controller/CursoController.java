package imd.ufrn.universidade_ufrn.controller;

import imd.ufrn.universidade_ufrn.DTO.AtualizarCursoDTO;
import imd.ufrn.universidade_ufrn.model.Curso;
import imd.ufrn.universidade_ufrn.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/cursos" , "/curso"})
public class CursoController {

    @Autowired
    CursoService curso;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid Curso dados){
        curso.cadastrarCurso(dados);
        curso.salvarAlunosPassados(dados.getAlunos());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Curso> listar(){
        return curso.listarCursos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAluno(@PathVariable Long id){
        curso.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizarAluno(@RequestBody @Valid AtualizarCursoDTO dados){
        curso.atualizarCurso(dados);
        return ResponseEntity.noContent().build();
    }


}
