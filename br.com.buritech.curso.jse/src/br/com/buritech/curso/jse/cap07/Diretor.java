package br.com.buritech.curso.jse.cap07;

import cap08.Autenticavel;

public class Diretor extends Funcionario implements Autenticavel {

	private int senha;

	public Diretor(String nome, double salario) {
		super(nome, salario);
		// TODO Auto-generated constructor stub
	}

	public Diretor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		// TODO Auto-generated constructor stub
	}

	public Diretor(double salario) {
		super(salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		return this.getSalario() * 0.5;
	}

	@Override
	public boolean autenticar(int senha) {
		return this.senha == senha;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

}
