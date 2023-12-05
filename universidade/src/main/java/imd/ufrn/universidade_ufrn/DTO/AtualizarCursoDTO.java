package imd.ufrn.universidade_ufrn.DTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarCursoDTO(

        @NotNull
        Long id,
        String nomeCurso,
        int cargaHoraria){
}
