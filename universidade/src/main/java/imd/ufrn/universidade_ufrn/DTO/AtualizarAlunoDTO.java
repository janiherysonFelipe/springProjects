package imd.ufrn.universidade_ufrn.DTO;


import imd.ufrn.universidade_ufrn.model.Curso;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
public record AtualizarAlunoDTO(
        @NotNull
        Long id,
        Curso curso,
        String nomeAluno,
        String cpf,
        String telefone,
        LocalDate nascimento) {

}
