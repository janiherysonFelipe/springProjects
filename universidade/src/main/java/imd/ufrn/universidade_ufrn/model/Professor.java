package imd.ufrn.universidade_ufrn.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "professor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;
    @NotNull
    private String nomeProfessor;
    @NotNull
    private String matricula;
    private  String titulacao;
}
