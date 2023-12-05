package imd.ufrn.universidade_ufrn.controller;

import imd.ufrn.universidade_ufrn.model.Instituicao;
import imd.ufrn.universidade_ufrn.service.InstituicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping
    public ResponseEntity<List<Instituicao>> listarInstituicao() {
        List<Instituicao> instituicaos = instituicaoService.listarDisciplinas();
        return ResponseEntity.ok(instituicaos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instituicao> buscarPorId(@PathVariable Long id) {
        Optional<Instituicao> instituicao = instituicaoService.buscarPorId(id);
        return instituicao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Instituicao> salvar(@Valid @RequestBody Instituicao instituicao) {
        Instituicao novaInstituicao = instituicaoService.salvar(instituicao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaInstituicao.getIdInstituicao()).toUri();
        return ResponseEntity.created(uri).body(novaInstituicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instituicao> atualizar(@PathVariable Long id, @Valid @RequestBody Instituicao instituicao) {
        Instituicao instituicaoAtualizada = instituicaoService.atualizar(id, instituicao);
        return ResponseEntity.ok(instituicaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        instituicaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
