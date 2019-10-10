package br.edu.ifsul.sapucaia.lp.service.mensagem;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
import br.edu.ifsul.sapucaia.lp.repository.IMensagemRepository;
@Service
public class BuscarMensagemPorIdService {
	@Autowired
	IMensagemRepository mensagemRepository;

	public Mensagem buscar(int id) {
		if(Objects.isNull(id) || id <= 0){
            throw new IllegalArgumentException("O Id não pode ficar em branco");
        }

        return mensagemRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Mensagem não encontrada"));
	}
}
