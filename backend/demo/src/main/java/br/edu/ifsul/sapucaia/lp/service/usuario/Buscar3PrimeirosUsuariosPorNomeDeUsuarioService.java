package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;

@Service
public class Buscar3PrimeirosUsuariosPorNomeDeUsuarioService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	public List<Usuario> buscar(String username) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}

		List<Usuario> usuarios = usuarioRepository.findFirst3ByUsernameContaining(username);
		if(usuarios.size() == 0){
			throw new IllegalArgumentException("Nenhum usuário foi encontrado");
		}else{
			return usuarios;
		}
	}
}