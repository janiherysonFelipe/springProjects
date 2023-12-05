package imd.ufrn.universidade_ufrn.controller;

import imd.ufrn.universidade_ufrn.model.Turma;
import imd.ufrn.universidade_ufrn.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> listarDisciplinas() {
        List<Turma> turmas = turmaService.listarTurmas();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Optional<Turma> turma = turmaService.buscarPorId(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> salvar(@Valid @RequestBody Turma turma) {
        Turma novaTurma = turmaService.salvar(turma);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaTurma.getIdTurma()).toUri();
        return ResponseEntity.created(uri).body(novaTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @Valid @RequestBody Turma turma) {
        Turma turmaAtualizada = turmaService.atualizar(id, turma);
        return ResponseEntity.ok(turmaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        turmaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
