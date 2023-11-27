package br.imd.ufrn.alunoIMD.usuarios.model;

public record RegistrarDTO(String login, String password, RoleEnum role) {
}
