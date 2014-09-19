package cap15;

import java.io.Serializable;

public class Mensagem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assunto;
	private String mensagem;
	
	public Mensagem(String assunto, String mesangem) {
		super();
		this.assunto = assunto;
		this.mensagem = mesangem;
	}

	@Override
	public String toString() {
		return "Assunto: " + assunto
				+ "\nMensagem: " + mensagem;
	}
	
	public final String getAssunto() {
		return assunto;
	}

	public final void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public final String getMesangem() {
		return mensagem;
	}

	public final void setMesangem(String mesangem) {
		this.mensagem = mesangem;
	}
	
}
