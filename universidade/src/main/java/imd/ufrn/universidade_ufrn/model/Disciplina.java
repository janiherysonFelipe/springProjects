package imd.ufrn.universidade_ufrn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "disciplina")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da disciplina é obrigatório")
    @Size(max = 300, message = "O nome da disciplina deve ter no máximo 300 caracteres")
    private String nomeDisciplina;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    private String descricao;

    @Size(max = 100, message = "A área deve ter no máximo 100 caracteres")
    private String area;
}
