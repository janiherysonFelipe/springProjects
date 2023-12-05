package imd.ufrn.universidade_ufrn.controller;

import imd.ufrn.universidade_ufrn.model.Professor;
import imd.ufrn.universidade_ufrn.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value={"/professores", "/professor"})
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = professorService.listarProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Optional<Professor> professor = professorService.buscarPorId(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Professor> salvar(@Valid @RequestBody Professor professor) {
        Professor novoProfessor = professorService.salvar(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoProfessor.getIdProfessor()).toUri();
        return ResponseEntity.created(uri).body(novoProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.atualizar(id, professor);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        professorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
