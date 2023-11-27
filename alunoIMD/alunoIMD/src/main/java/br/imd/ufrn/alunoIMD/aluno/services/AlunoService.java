package br.imd.ufrn.alunoIMD.aluno.services;

import br.imd.ufrn.alunoIMD.aluno.repository.AlunoRepository;
import br.imd.ufrn.alunoIMD.aluno.model.AlunoEntity;
import br.imd.ufrn.alunoIMD.aluno.model.DadosAtualizarAluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    @Transactional
    public void cadastrarAluno(AlunoEntity dados){
        repository.save(new AlunoEntity(dados));
    }

    public List<AlunoEntity> listarAlunos(){
        return repository.findAllByAtivoTrue();
    }

    @Transactional
    public void atualizarAluno(DadosAtualizarAluno dados){
        AlunoEntity aluno = repository.getReferenceById(dados.id());
        aluno.atualizarAluno(dados);
    }

    @Transactional
    public void deletarAluno(long id){
        repository.deleteById(id);
    }

    @Transactional
    public void inativar(long id){
        AlunoEntity aluno = repository.getReferenceById(id);
        aluno.inativar();
    }

    //@Autowired
    //@Qualifier("aplicationName")
    @Value("${application.name}")
    private String nomeApplicacao;

    @Value("${server.port}")
    private String porta;

    public String aplicationName(){
        return "Nome da aplicação: " + nomeApplicacao + "\n" + "Porta: " + porta ;
    }

}
