package br.edu.ifsul.sapucaia.lp.dominio.dto;

public class EdicaoRequestDto {
    private String nome;
    private String senha;
    private String confirmarSenha;

    public EdicaoRequestDto() {

    }

    public EdicaoRequestDto(String nome, String senha, String confirmarSenha) {
        this.nome = nome;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return this.confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
