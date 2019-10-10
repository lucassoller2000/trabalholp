package br.edu.ifsul.sapucaia.lp.service.login;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.dominio.dto.LoginRequestDto;
import br.edu.ifsul.sapucaia.lp.dominio.dto.LoginResponseDto;
import br.edu.ifsul.sapucaia.lp.security.password.Criptografia;
import br.edu.ifsul.sapucaia.lp.security.AuthenticationService;
import br.edu.ifsul.sapucaia.lp.service.usuario.BuscarUsuarioPorUsernameService;

@Service
public class LoginService {
	@Autowired
	private BuscarUsuarioPorUsernameService buscarUsuario;
	
    @Autowired
    AuthenticationService authenticationService;

	public LoginResponseDto logar(LoginRequestDto loginDto){
		if(Objects.isNull(loginDto.getUsername()) || loginDto.getUsername().isEmpty()){
			throw new IllegalArgumentException("O nome de usuário não pode estar em branco");

		}
		if(Objects.isNull(loginDto.getSenha()) || loginDto.getSenha().isEmpty()){
			throw new IllegalArgumentException("A senha não pode estar em branco");

		}

		Criptografia criptografia = new Criptografia();
		Usuario usuario = buscarUsuario.buscar(loginDto.getUsername());

		if(!criptografia.senhaIgual(loginDto.getSenha(), usuario.getSenha())){
			throw new IllegalArgumentException("Senha incorreta");
		}

		String token = authenticationService.authenticate(loginDto.getUsername(), usuario.getSenha());
		return new LoginResponseDto(loginDto.getUsername(), token);
	}
}
