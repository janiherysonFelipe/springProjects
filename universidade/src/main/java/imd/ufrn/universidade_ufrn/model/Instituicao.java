package imd.ufrn.universidade_ufrn.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "instituicao")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInstituicao")
    private Long idInstituicao;

    @Column
    private String nomeInstituicao;

    @Column
    @CNPJ
    private String cnpj;

    @Column
    private String endereco;
}