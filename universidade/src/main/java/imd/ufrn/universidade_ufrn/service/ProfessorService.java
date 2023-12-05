package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.model.Professor;
import imd.ufrn.universidade_ufrn.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor salvar(Professor professor) {
        // Adicione validações aqui, se necessário
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, Professor professor) {
        // Adicione validações aqui, se necessário
        professor.setIdProfessor(id);
        return professorRepository.save(professor);
    }

    public ResponseEntity excluir(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        professorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
