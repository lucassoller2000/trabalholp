// package br.edu.ifsul.sapucaia.lp.service.mensagem;

// import java.util.List;
// import java.util.Objects;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
// import br.edu.ifsul.sapucaia.lp.repository.IMensagemRepository;

// @Service
// public class BuscarMensagensPorPalavrasChave {
// 	@Autowired
// 	IMensagemRepository mensagemRepository;

// 	public List<Mensagem> buscar(String conteudo) {
// 		if (Objects.isNull(conteudo) || conteudo.isEmpty()) {
// 			throw new IllegalArgumentException("O texto não pode ficar em branco");
// 		}

//         List<Mensagem> mensagens = mensagemRepository.findByConteudoContainingOrderByDataDeEnvioDesc(conteudo);
//         if(mensagens.size() == 0){
//             throw new IllegalArgumentException("Nenhuma mensagem encontrada");
//         }
//         return mensagens;    
// 	}
// }
