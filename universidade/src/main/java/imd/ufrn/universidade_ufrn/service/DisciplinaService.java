package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.model.Disciplina;
import imd.ufrn.universidade_ufrn.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvar(Disciplina disciplina) {
        // Adicione validações aqui, se necessário
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long id, Disciplina disciplina) {
        // Adicione validações aqui, se necessário
        disciplina.setId(id);
        return disciplinaRepository.save(disciplina);
    }

    public ResponseEntity excluir(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        disciplinaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}