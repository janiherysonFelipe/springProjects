package br.imd.ufrn.alunoIMD.services;

import br.imd.ufrn.alunoIMD.model.AlunoRepository;
import br.imd.ufrn.alunoIMD.model.DadosAluno;
import br.imd.ufrn.alunoIMD.model.DadosAtualizarAluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    @Transactional
    public void cadastrarAluno(DadosAluno dados){
        repository.save(new DadosAluno(dados));
    }

    public List<DadosAluno> listarAlunos(){
        return repository.findAllByAtivoTrue();
    }

    @Transactional
    public void atualizarAluno(DadosAtualizarAluno dados){
        DadosAluno aluno = repository.getReferenceById(dados.id());
        aluno.atualizarAluno(dados);
    }

    @Transactional
    public void deletarAluno(long id){
        repository.deleteById(id);
    }

    @Transactional
    public void inativar(long id){
        DadosAluno aluno = repository.getReferenceById(id);
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
