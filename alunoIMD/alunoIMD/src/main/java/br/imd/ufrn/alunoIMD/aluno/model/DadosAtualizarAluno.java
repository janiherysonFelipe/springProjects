package br.imd.ufrn.alunoIMD.aluno.model;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        @NotNull
        long id,
        String nome, String cpf,  String endereco,  String telefone,  String matricula,
        String curso,  String data_de_nascimento,  String data_de_ingresso,  GeneroEnum genero) {

}
