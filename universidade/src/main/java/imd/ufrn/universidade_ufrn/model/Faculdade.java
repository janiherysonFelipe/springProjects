package imd.ufrn.universidade_ufrn.model;

import imd.ufrn.universidade_ufrn.DTO.AtualizarFaculdadeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "faculdade")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Faculdade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFaculdade;
    private String nomeFaculdade;
    private String descricao;
    private String area;

    @OneToMany(mappedBy = "faculdade") //Uma faculdade tem muitos cursos
    private List<Curso> cursos;

    public Faculdade(Faculdade faculdade){

        this.nomeFaculdade = faculdade.getNomeFaculdade();
        this.descricao = faculdade.getDescricao();
        this.area = faculdade.getArea();
    }

    public void atualizarFaculdade(AtualizarFaculdadeDTO dados) {
        if(dados.nomeFaculdade() != null){
            this.nomeFaculdade = dados.nomeFaculdade();
        }if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }if(dados.area() != null){
            this.area = dados.area();
        }
    }
}