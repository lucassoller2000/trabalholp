package br.edu.ifsul.sapucaia.lp.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private String usuario;
    @JsonIgnore
    private String senha;
    // private String foto;

    private Collection<? extends GrantedAuthority> authorities;

    // public String getFoto() {
    //     return foto;
    // }

    // public void setFoto(String foto) {
    //     this.foto = foto;
    // }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserPrincipal(String usuario, String senha, 
    // String foto,
            Collection<? extends GrantedAuthority> authorities) {
        this.usuario = usuario;
        this.senha = senha;
        // this.foto = foto;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Usuario usuario) {
        List<GrantedAuthority> authorities = Arrays.asList(
            new SimpleGrantedAuthority(usuario.getRole().orElse(DEFAULT_ROLE))
        );

        return new UserPrincipal(
            usuario.getUsername(),
            usuario.getSenha(),
            // usuario.getFoto(),
            authorities
        );
    }

    @Override
    public String getUsername() {
        return usuario;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}