package br.edu.ifsul.sapucaia.lp.service.usuario;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.dominio.dto.EdicaoRequestDto;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;
import br.edu.ifsul.sapucaia.lp.security.password.Criptografia;

@Service
public class EditarUsuarioService{

@Autowired
	IUsuarioRepository usuarioRepository;

	@Autowired
	BuscarUsuarioPorUsernameService buscarUsuario;

	public void editar(String username, EdicaoRequestDto edicaoDto){
		if(Objects.isNull(username) || username.isEmpty()){
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}
		Usuario usuario = buscarUsuario.buscar(username);

		if(!Objects.isNull(edicaoDto.getSenha()) && !edicaoDto.getSenha().isEmpty()){
			if(Objects.isNull(edicaoDto.getConfirmarSenha()) || edicaoDto.getConfirmarSenha().isEmpty()){
				throw new IllegalArgumentException("Confirme sua senha");
			}

			if(!edicaoDto.getSenha().equals(edicaoDto.getConfirmarSenha())){
				throw new IllegalArgumentException("As senhas não coincidem");
			}
			Criptografia criptografia = new Criptografia();
			usuario.setSenha(criptografia.criptografarSenha(edicaoDto.getSenha()));
		}

		if(!Objects.isNull(edicaoDto.getNome()) && !edicaoDto.getNome().isEmpty()){
			usuario.setNome(edicaoDto.getNome());
		}
		usuarioRepository.save(usuario);
	}
}		
