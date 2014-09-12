package br.com.buritech.curso.jse.cap06;

public class Conhecido extends Pessoa {
	private String email;

	public Conhecido() {
		super();
		
		this.email = "indefinido";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
