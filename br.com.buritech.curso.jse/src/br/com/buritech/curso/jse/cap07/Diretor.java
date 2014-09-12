package br.com.buritech.curso.jse.cap07;

public class Diretor extends Funcionario {

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

}
