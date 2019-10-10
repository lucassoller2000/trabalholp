package br.edu.ifsul.sapucaia.lp.repository;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByUsernameAndSenha(String username, String senha);
    Page<Usuario> findByUsernameContaining(String username, Pageable pageable);
    List<Usuario> findFirst3ByUsernameContaining(String username);
}
