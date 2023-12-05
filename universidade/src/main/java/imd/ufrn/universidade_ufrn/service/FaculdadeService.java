package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.DTO.AtualizarFaculdadeDTO;
import imd.ufrn.universidade_ufrn.model.Faculdade;
import imd.ufrn.universidade_ufrn.repository.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FaculdadeService {

    @Autowired
    FaculdadeRepository repository;


    public ResponseEntity cadastrarFaculdade (Faculdade faculdade){
        repository.save(new Faculdade(faculdade));
        return  ResponseEntity.noContent().build();
    }


    @Transactional
    public ResponseEntity deletarFaculdade(Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }


    public List<Faculdade> listarFaculdades(){
        return repository.findAll();
    }

    @Transactional
    public ResponseEntity atualizarFaculdade(AtualizarFaculdadeDTO dados) {
        if(dados.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Faculdade faculdade = repository.getReferenceById(dados.id());
        faculdade.atualizarFaculdade(dados);
        return ResponseEntity.ok().build();

    }

}
