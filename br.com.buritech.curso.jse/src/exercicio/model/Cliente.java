package exercicio.model;

import cap08.Autenticavel;

public class Cliente implements Autenticavel {
	private String cpf;
	private String nome;

	private int senha;

	public Cliente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public Cliente(String nome, int senha) {
		super();
		
		this.nome = nome;
		this.senha = senha;
	}
	
	public Cliente() {
		super();
	}

	@Override
	public boolean autenticar(int senha) {
		
		return this.senha == senha;
	}

	@Override
	public String toString() {
		return "[" + cpf + "]" + nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public final int getSenha() {
		return senha;
	}

	public final void setSenha(int senha) {
		this.senha = senha;
	}

}
