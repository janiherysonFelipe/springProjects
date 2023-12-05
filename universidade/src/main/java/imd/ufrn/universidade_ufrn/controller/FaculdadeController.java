package imd.ufrn.universidade_ufrn.controller;

import imd.ufrn.universidade_ufrn.DTO.AtualizarFaculdadeDTO;
import imd.ufrn.universidade_ufrn.model.Faculdade;
import imd.ufrn.universidade_ufrn.service.FaculdadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculdade")
public class FaculdadeController {

    @Autowired
    FaculdadeService faculdade;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid Faculdade dados){
        faculdade.cadastrarFaculdade(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Faculdade> listar(){
        return faculdade.listarFaculdades();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFaculdade(@PathVariable Long id){
        faculdade.deletarFaculdade(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity atualizarFaculdade(@RequestBody @Valid AtualizarFaculdadeDTO dados){
        faculdade.atualizarFaculdade(dados);
        return ResponseEntity.noContent().build();
    }
}
