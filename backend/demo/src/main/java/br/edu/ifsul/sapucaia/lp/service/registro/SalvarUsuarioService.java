package br.edu.ifsul.sapucaia.lp.service.registro;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.dominio.dto.RegistroRequestDto;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;
import br.edu.ifsul.sapucaia.lp.security.password.Criptografia;
import br.edu.ifsul.sapucaia.lp.service.usuario.BuscarUsernameUsadoService;

@Service
public class SalvarUsuarioService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Autowired
	BuscarUsernameUsadoService buscarUsernameUsadoService;

	public void salvar(RegistroRequestDto registroDto) {
		if (Objects.isNull(registroDto)) {
			throw new IllegalArgumentException();
		}
		if (Objects.isNull(registroDto.getUsername()) || registroDto.getUsername().isEmpty()) {
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");
		}
		if(registroDto.getUsername().contains(";")){
			throw new IllegalArgumentException("O nome de usuário não pode conter este tipo de caractere");
		}
		if (Objects.isNull(registroDto.getNome()) || registroDto.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome não pode estar em branco");
		}
		if (Objects.isNull(registroDto.getSenha()) || registroDto.getSenha().isEmpty()) {
			throw new IllegalArgumentException("A senha não pode estar em branco");
		}
		if (Objects.isNull(registroDto.getConfirmarSenha()) || registroDto.getConfirmarSenha().isEmpty()) {
			throw new IllegalArgumentException("Confirme sua senha");
		}
		if(!registroDto.getSenha().equals(registroDto.getConfirmarSenha())){
			throw new IllegalArgumentException("As senhas não coincidem");
		}
		
		buscarUsernameUsadoService.buscar(registroDto.getUsername());

		Usuario usuario = new Usuario(registroDto.getUsername(), registroDto.getNome(), registroDto.getSenha());
		
		Criptografia criptografia = new Criptografia();
		usuario.setSenha(criptografia.criptografarSenha(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
}