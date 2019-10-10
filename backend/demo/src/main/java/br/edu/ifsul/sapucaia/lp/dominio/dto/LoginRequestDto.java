package br.edu.ifsul.sapucaia.lp.dominio.dto;

public class LoginRequestDto {
    private String username;
    private String senha;

    public LoginRequestDto(){

    }

    public LoginRequestDto(String username, String senha){
        this.username = username;
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
