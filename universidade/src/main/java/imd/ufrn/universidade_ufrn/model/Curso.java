package imd.ufrn.universidade_ufrn.model;

import imd.ufrn.universidade_ufrn.DTO.AtualizarCursoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "curso")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    @NotNull
    private String nomeCurso;
    @NotNull
    private int cargaHoraria;

    @OneToMany(mappedBy = "curso") //Um curso tem muitos alunos

    private List<Aluno> alunos;

    @ManyToOne //Muitos cursos podem estar associados a um facluldade
    @JoinColumn(name="id_faculdade")
    private Faculdade faculdade;


    public Curso(Curso curso){
        this.nomeCurso = curso.getNomeCurso();
        this.cargaHoraria = curso.getCargaHoraria();
        this.alunos = curso.getAlunos();
    }

    public void atualizarCurso(AtualizarCursoDTO dados) {
        if(dados.nomeCurso() != null){
            this.nomeCurso = dados.nomeCurso();
        }if(dados.cargaHoraria() != this.cargaHoraria){
            this.cargaHoraria = dados.cargaHoraria();
        }
    }



}


