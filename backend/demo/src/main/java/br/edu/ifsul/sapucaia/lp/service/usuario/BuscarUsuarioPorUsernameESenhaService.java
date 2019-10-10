package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;

@Service
public class BuscarUsuarioPorUsernameESenhaService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	public Usuario buscar(String username, String senha) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}

		if (Objects.isNull(senha) || senha.isEmpty()) {
			throw new IllegalArgumentException("A senha não pode estar em branco");
		}

		return usuarioRepository.findByUsernameAndSenha(username, senha)
				.orElseThrow(() -> new IllegalArgumentException("Nome de usuário ou senha incorretos"));
	}
}
