package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;

@Service
public class BuscarUsuarioPorUsernameService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	public Usuario buscar(String username) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}

		return usuarioRepository.findByUsername(username)
			.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
		
	}
}