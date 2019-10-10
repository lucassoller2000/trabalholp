package br.edu.ifsul.sapucaia.lp.security;

import java.util.Optional;
import java.util.function.Supplier;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
* Service para obter dados do usuário no contexto de autenticação
*/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = getUser(() -> usuarioRepository.findByUsername(username));
        return UserPrincipal.create(usuario);
    }

    private Usuario getUser(Supplier<Optional<Usuario>> supplier) {
        return supplier.get().orElseThrow(() ->
            new UsernameNotFoundException("Usuário não cadastrado")
        );
    }
}
