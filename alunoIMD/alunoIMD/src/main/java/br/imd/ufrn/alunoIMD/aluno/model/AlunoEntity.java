package br.imd.ufrn.alunoIMD.aluno.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "alunos")
@Entity(name = "Alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoEntity {

    public AlunoEntity(AlunoEntity dados) {
        this.ativo = true;
        this.nome = dados.nome;
        this.cpf = dados.cpf;
        this.data_de_ingresso = dados.data_de_ingresso;
        this.curso = dados.curso;
        this.data_de_nascimento = dados.data_de_nascimento;
        this.genero = dados.genero;
        this.endereco = dados.endereco;
        this.matricula = dados.matricula;
        this.telefone = dados.telefone;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String matricula;
    private String curso;
    private String data_de_nascimento;
    private String data_de_ingresso;
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private boolean ativo;


    public void atualizarAluno(DadosAtualizarAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }if(dados.endereco() != null){
            this.endereco = dados.endereco();
        }if(dados.curso() != null){
            this.curso = dados.curso();
        }if(dados.genero() != null){
            this.genero = dados.genero();
        }if(dados.data_de_ingresso() != null){
            this.data_de_ingresso = dados.data_de_ingresso();
        }if(dados.data_de_nascimento() != null){
            this.data_de_nascimento = dados.data_de_nascimento();
        }if(dados.matricula() != null){
            this.matricula = dados.matricula();
        }if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
