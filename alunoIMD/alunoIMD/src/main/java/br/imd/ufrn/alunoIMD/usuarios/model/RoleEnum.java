package br.imd.ufrn.alunoIMD.usuarios.model;

public enum RoleEnum {
    ADMIN("admin"),
    USUARIO("users");

    private String role;

    RoleEnum(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
