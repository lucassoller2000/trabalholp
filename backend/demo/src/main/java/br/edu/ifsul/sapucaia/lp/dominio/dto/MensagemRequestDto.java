package br.edu.ifsul.sapucaia.lp.dominio.dto;

public class MensagemRequestDto {
	private String conteudo;
	private String destinatario;

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}


	public MensagemRequestDto() {
	}

	public MensagemRequestDto(String destinatario, String conteudo) {
		this.destinatario = destinatario;
		this.conteudo = conteudo;
	}

}
