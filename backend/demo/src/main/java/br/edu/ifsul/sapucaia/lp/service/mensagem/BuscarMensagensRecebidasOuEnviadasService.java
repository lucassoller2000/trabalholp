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
public class BuscarMensagensRecebidasOuEnviadasService {
	@Autowired
	IMensagemRepository mensagemRepository;

	@Autowired
	BuscarUsuarioPorUsernameService buscarUsuario;

	public Page<Mensagem> buscar(String username1, String username2, String conteudo, int pagina) {
		if (Objects.isNull(username1) || username1.isEmpty()) {
			throw new IllegalArgumentException("Usuário não cadastrado");
		}

		if (Objects.isNull(username2) || username2.isEmpty()) {
			throw new IllegalArgumentException("Usuário não cadastrado");
		}

		buscarUsuario.buscar(username1);
		buscarUsuario.buscar(username2);

		Page<Mensagem> mensagens = mensagemRepository.queryMensagensRecebidasOuEnviadas(username1, username2, conteudo, PageRequest.of(pagina, 10));
        if(mensagens.getTotalElements() == 0){
            throw new IllegalArgumentException("Nenhum mensagem foi encontrada");
        }else{
            return mensagens;
        }	
	}
}
