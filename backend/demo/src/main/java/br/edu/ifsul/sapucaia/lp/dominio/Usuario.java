package br.edu.ifsul.sapucaia.lp.dominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Optional;

@Entity
public class Usuario {

    @Id
    @Column(unique = true)
    private String username;

    private String nome;

    @JsonIgnore
    @Column(nullable = false)
    private String senha;

    @JsonIgnore
    public Optional<String> getRole() {
        return Optional.of("Usuario normal");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(String username, String nome,  String senha) {
        this.username = username;
        this.nome = nome;
        this.senha = senha;
    }
}
