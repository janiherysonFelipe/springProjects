package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.model.Turma;
import imd.ufrn.universidade_ufrn.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;


    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma salvar(Turma turma) {
        // Adicione validações aqui, se necessário
        return turmaRepository.save(turma);
    }

    public Turma atualizar(Long id, Turma turma) {
        // Adicione validações aqui, se necessário
        turma.setIdTurma(id);
        return turmaRepository.save(turma);
    }

    public ResponseEntity excluir(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        turmaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
