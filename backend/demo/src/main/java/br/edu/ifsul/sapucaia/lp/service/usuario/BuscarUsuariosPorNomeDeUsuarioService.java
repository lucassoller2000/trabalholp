package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;

@Service
public class BuscarUsuariosPorNomeDeUsuarioService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	public Page<Usuario> buscar(String username, int pagina) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}

		Page<Usuario> usuarios = usuarioRepository.findByUsernameContaining(username, PageRequest.of(pagina,10));
		if(usuarios.getTotalElements() == 0){
			throw new IllegalArgumentException("Nenhum usuário foi encontrado");
		}else{
			return usuarios;
		}
	}
}