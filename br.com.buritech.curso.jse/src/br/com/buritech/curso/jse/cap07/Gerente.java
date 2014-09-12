package br.com.buritech.curso.jse.cap07;

public class Gerente extends Funcionario {

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
}
