package imd.ufrn.universidade_ufrn.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "turma")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTurma;
    @NotNull
    private String nomeTurma;
    private String descricao;

    @ManyToMany(mappedBy = "turmas")
    Set<Aluno> alunos;
}
