package br.edu.ifsul.sapucaia.lp.service.mensagem;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.dominio.dto.MensagemRequestDto;
import br.edu.ifsul.sapucaia.lp.repository.IMensagemRepository;
import br.edu.ifsul.sapucaia.lp.service.usuario.BuscarUsuarioPorUsernameService;

@Service
public class SalvarMensagemService {
    @Autowired
    IMensagemRepository mensagemRepository;

    @Autowired
    BuscarUsuarioPorUsernameService buscarUsuario;

    public void salvar(String username, MensagemRequestDto mensagemDto){

        if(Objects.isNull(mensagemDto.getConteudo()) || mensagemDto.getConteudo().isEmpty()){
            throw new IllegalArgumentException("O conteúdo da mensagem não pode ficar em branco");
        }

        if(Objects.isNull(username) || username.isEmpty()){
            throw new IllegalArgumentException("O usuário remetente não pode ficar em branco");
        }

        if(Objects.isNull(mensagemDto.getDestinatario()) || mensagemDto.getDestinatario().isEmpty()){
            throw new IllegalArgumentException("O usuário destinatário não pode ficar em branco");
        }

        String[]destinatarios = mensagemDto.getDestinatario().split(";");

        Usuario remetente = buscarUsuario.buscar(username);
        for(String d : destinatarios){
            Usuario destinatario = buscarUsuario.buscar(d);
            Mensagem mensagem = new Mensagem(remetente, destinatario, mensagemDto.getConteudo());
            mensagemRepository.save(mensagem);
        }
    }
}