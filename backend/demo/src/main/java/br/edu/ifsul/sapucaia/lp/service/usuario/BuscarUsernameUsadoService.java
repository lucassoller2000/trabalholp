package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;


@Service
public class BuscarUsernameUsadoService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	public void buscar(String username) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}

		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		if(usuario.isPresent()){
			throw new IllegalArgumentException("O nome de usuário já está em uso");
		}
	}
}
