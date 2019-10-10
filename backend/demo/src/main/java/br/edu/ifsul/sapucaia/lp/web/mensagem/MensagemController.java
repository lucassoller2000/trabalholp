package br.edu.ifsul.sapucaia.lp.web.mensagem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
import br.edu.ifsul.sapucaia.lp.dominio.dto.MensagemRequestDto;
import br.edu.ifsul.sapucaia.lp.repository.IMensagemRepository;
import br.edu.ifsul.sapucaia.lp.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagemPorIdService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagemPorUsuarioService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagensPorDestinatarioService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagensPorRemetenteService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagensRecebidasEEnviadasService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.BuscarMensagensRecebidasOuEnviadasService;
import br.edu.ifsul.sapucaia.lp.service.mensagem.SalvarMensagemService;

@RequestMapping("/mensagem")
@RestController
public class MensagemController {

	@Autowired
	private BuscarMensagemPorUsuarioService buscarMensagemPorUsuario;

	@Autowired
	private BuscarMensagensPorRemetenteService buscarMensagensPorRemetente;

	@Autowired
	private BuscarMensagensPorDestinatarioService buscarMensagensPorDestinatario;

	@Autowired
	private SalvarMensagemService salvarMensagemService;

	@Autowired
	private BuscarMensagemPorIdService buscarMensagemPorId;

	@Autowired
	private BuscarMensagensRecebidasEEnviadasService buscarMensagens;

	@Autowired
	private BuscarMensagensRecebidasOuEnviadasService buscarMensagensRecebidasOuEnviadas;

	@Autowired
	private IMensagemRepository mensagemRepository;

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody MensagemRequestDto mensagemDto) {
		salvarMensagemService.salvar(userPrincipal.getUsername(), mensagemDto);
	}

	
	@GetMapping
	@ResponseBody
	public List<Mensagem> buscarTodos() {
		return mensagemRepository.findAll();
	}

	@GetMapping("/buscar/{id}")
	@ResponseBody
	public Mensagem buscarPorId(@PathVariable("id") int id) {
		return buscarMensagemPorId.buscar(id);
	}
	// GET

	@GetMapping("/buscar/{username}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarRecebidasEEnviadas(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("pagina") int pagina) {
		return buscarMensagens.buscar(userPrincipal.getUsername(), username, "", pagina);
	}

	@GetMapping("/buscar/recebidas/{username}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarMensagensRecebidas(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("pagina") int pagina) {
		return buscarMensagensRecebidasOuEnviadas.buscar(userPrincipal.getUsername(), username, "", pagina);
	}

	@GetMapping("/buscar/enviadas/{username}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarMensagensEnviadas(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("pagina") int pagina) {
		return buscarMensagensRecebidasOuEnviadas.buscar(username, userPrincipal.getUsername(), "", pagina);
	}

	@GetMapping("/buscar/usuario/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorUsuario(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("pagina") int pagina) {
		return buscarMensagemPorUsuario.buscar(userPrincipal.getUsername(), "", pagina);
	}

	@GetMapping("/buscar/usuario/remetente/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorRemetente(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("pagina") int pagina){
		return buscarMensagensPorRemetente.buscar(userPrincipal.getUsername(), "",pagina);
	}

	@GetMapping("/buscar/usuario/destinatario/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorDestinatario(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("pagina") int pagina){
		return buscarMensagensPorDestinatario.buscar(userPrincipal.getUsername(), "", pagina);
	}


	// GET COM CONTEUDO
	@GetMapping("/buscar/{username}/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarRecebidasEEnviadasComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina) {
		return buscarMensagens.buscar(userPrincipal.getUsername(), username, conteudo, pagina);
	}

	@GetMapping("/buscar/recebidas/{username}/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarMensagensRecebidasComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina) {
		return buscarMensagens.buscar(userPrincipal.getUsername(), username, conteudo, pagina);
	}

	@GetMapping("/buscar/enviadas/{username}/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarMensagensEnviadasComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("username") String username, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina) {
		return buscarMensagens.buscar(username, userPrincipal.getUsername(), conteudo, pagina);
	}

	@GetMapping("/buscar/usuario/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorUsuarioComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina) {
		return buscarMensagemPorUsuario.buscar(userPrincipal.getUsername(), conteudo, pagina);
	}

	@GetMapping("/buscar/usuario/remetente/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorRemetenteComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina){
		return buscarMensagensPorRemetente.buscar(userPrincipal.getUsername(), conteudo, pagina);
	}

	@GetMapping("/buscar/usuario/destinatario/{conteudo}/{pagina}")
	@ResponseBody
	public Page<Mensagem> buscarPorDestinatarioComConteudo(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("conteudo") String conteudo, @PathVariable("pagina") int pagina){
		return buscarMensagensPorDestinatario.buscar(userPrincipal.getUsername(), conteudo, pagina);
	}
}