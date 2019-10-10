package br.edu.ifsul.sapucaia.lp.service.mensagem;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
import br.edu.ifsul.sapucaia.lp.repository.IMensagemRepository;
import br.edu.ifsul.sapucaia.lp.service.usuario.BuscarUsuarioPorUsernameService;

@Service
public class BuscarMensagemPorUsuarioService {
	@Autowired
	IMensagemRepository mensagemRepository;

	@Autowired
	BuscarUsuarioPorUsernameService buscarUsuario;

	public Page<Mensagem> buscar(String username, String conteudo, int pagina) {
		if (Objects.isNull(username) || username.isEmpty()) {
			throw new IllegalArgumentException("Usuário não cadastrado");
		}

		buscarUsuario.buscar(username);
        Page<Mensagem> mensagens = mensagemRepository.queryMensagens(username, conteudo, PageRequest.of(pagina, 10));
        if(mensagens.getTotalElements() == 0){
            throw new IllegalArgumentException("Nenhum mensagem foi encontrada");
        }else{
            return mensagens;
        }	
	}
}
