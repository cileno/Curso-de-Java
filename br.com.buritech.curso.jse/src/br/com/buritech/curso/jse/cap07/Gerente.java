package br.com.buritech.curso.jse.cap07;

import cap08.Autenticavel;

public class Gerente extends Funcionario implements Autenticavel {

	private int senha;

	public Gerente(double salario) {
		super(salario);
	}

	public Gerente(String nome, double salario) {
		super(nome, salario);
	}

	public Gerente(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}

	@Override
	public double getBonus() {
		return this.getSalario() * 0.4;
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
