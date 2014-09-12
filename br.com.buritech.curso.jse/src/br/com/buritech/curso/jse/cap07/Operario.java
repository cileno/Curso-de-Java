package br.com.buritech.curso.jse.cap07;

public class Operario extends Funcionario {

	public Operario(double salario) {
		super(salario);
		// TODO Auto-generated constructor stub
	}

	public Operario(String nome, double salario) {
		super(nome, salario);
		// TODO Auto-generated constructor stub
	}

	public Operario(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		return this.getSalario() * 0.2;
	}

}
