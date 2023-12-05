package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.model.Instituicao;
import imd.ufrn.universidade_ufrn.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public List<Instituicao> listarDisciplinas() {
        return instituicaoRepository.findAll();
    }

    public Optional<Instituicao> buscarPorId(Long id) {
        return instituicaoRepository.findById(id);
    }

    public Instituicao salvar(Instituicao instituicao) {
        // Adicione validações aqui, se necessário
        return instituicaoRepository.save(instituicao);
    }

    public Instituicao atualizar(Long id, Instituicao instituicao) {
        // Adicione validações aqui, se necessário
        instituicao.setIdInstituicao(id);
        return instituicaoRepository.save(instituicao);
    }

    public ResponseEntity excluir(Long id) {
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        instituicaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
