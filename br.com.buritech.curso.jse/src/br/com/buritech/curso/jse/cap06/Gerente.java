package br.com.buritech.curso.jse.cap06;

public class Gerente extends Funcionario {
	private int senha;
	
	public Gerente() {
		super();
	}
	public Gerente(double salario) {
		super(salario);
	}

	public Gerente(String cpf, String nome, double salario) {
		super(cpf, nome, salario);
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public boolean autenticar (int senha) {
		return (this.senha == senha);
	}
	@Override
	public double getBonus() {
		return getSalario() * 0.15;
	}
}
