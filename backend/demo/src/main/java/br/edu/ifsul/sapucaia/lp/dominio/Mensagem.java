package br.edu.ifsul.sapucaia.lp.dominio;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuario_remetente")
    private Usuario remetente;
    
    @ManyToOne
	@JoinColumn(name = "usuario_destinatario")
	private Usuario destinatario;
	private Date dataDeEnvio;
	private String conteudo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getRemetente() {
		return remetente;
	}

	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Mensagem(Usuario remetente, Usuario destinatario, String conteudo) {
		super();
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.conteudo = conteudo;
		this.dataDeEnvio =  new Date();
	}

	public Mensagem() {
		super();
	}

	public Date getDataDeEnvio() {
		return dataDeEnvio;
	}

	public void setDataDeEnvio(Date dataDeEnvio) {
		this.dataDeEnvio = dataDeEnvio;
	}
}
