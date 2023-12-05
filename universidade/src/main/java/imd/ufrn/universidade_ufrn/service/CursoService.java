package imd.ufrn.universidade_ufrn.service;

import imd.ufrn.universidade_ufrn.DTO.AtualizarCursoDTO;
import imd.ufrn.universidade_ufrn.model.Aluno;
import imd.ufrn.universidade_ufrn.model.Curso;
import imd.ufrn.universidade_ufrn.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository repository;

    @Autowired
    AlunoService aluno;


    public ResponseEntity cadastrarCurso (Curso curso){
        repository.save(new Curso(curso));
        return  ResponseEntity.noContent().build();
    }

    public void salvarAlunosPassados(List<Aluno> alunos){
        if(alunos != null){
            aluno.salvarAlunosSeparadamente(alunos);
        }

    }
    //Excluir um aluno da tabela pelo seu ID
    @Transactional
    public ResponseEntity deletarCurso(Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }


    public List<Curso> listarCursos(){
        return  repository.findAll();
    }

    @Transactional
    public ResponseEntity atualizarCurso(AtualizarCursoDTO dados) {
        if(dados.id() == null){
            return ResponseEntity.badRequest().build();
        }
        Curso curso = repository.getReferenceById(dados.id());
        curso.atualizarCurso(dados);
        return ResponseEntity.ok().build();

    }

}
