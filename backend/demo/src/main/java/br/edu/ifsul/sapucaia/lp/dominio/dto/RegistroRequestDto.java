
package br.edu.ifsul.sapucaia.lp.dominio.dto;
public class RegistroRequestDto {

    private String username;
    private String nome;
    private String senha;
    private String confirmarSenha;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public RegistroRequestDto() {
    }

    public RegistroRequestDto (String username, String nome, String senha, String confirmarSenha){
        this.username = username;
        this.nome = nome;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}
