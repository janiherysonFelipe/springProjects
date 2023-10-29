package br.imd.ufrn.alunoIMD.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface alunoRepository extends JpaRepository<DadosAluno, Long> {
    List<DadosAluno> findAllByAtivoTrue();
}
