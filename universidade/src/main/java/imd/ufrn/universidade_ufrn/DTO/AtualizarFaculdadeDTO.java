package imd.ufrn.universidade_ufrn.DTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarFaculdadeDTO(
        @NotNull
        Long id,
        String nomeFaculdade,
        String descricao,
        String area) {
}
