package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.DTO.AtualizarAlunoDTO;
import imd.ufrn.universidade_ufrn.model.Aluno;
import imd.ufrn.universidade_ufrn.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    //Cadastra um novo usuario da tabela alunos
    public ResponseEntity cadastrarAluno (Aluno aluno){
        repository.save(new Aluno(aluno));
        return  ResponseEntity.noContent().build();
    }

    @Transactional
    public void salvarAlunosSeparadamente(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            repository.save(aluno);
        }
    }

    //Excluir um aluno da tabela pelo seu ID
    @Transactional
    public ResponseEntity deletarAluno(Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }


    public List<Aluno> listarAlunos(){
        return  repository.findAll();
    }

    @Transactional
    public ResponseEntity atualizarAluno(AtualizarAlunoDTO dados) {
        if(dados.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Aluno aluno = repository.getReferenceById(dados.id());
        aluno.atualizarAluno(dados);
        return ResponseEntity.ok().build();

    }
}
