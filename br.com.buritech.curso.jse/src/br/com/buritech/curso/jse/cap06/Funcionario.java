package br.com.buritech.curso.jse.cap06;

public class Funcionario {
	private String cpf;
	private String nome;
	private double salario;

	public Funcionario() {
		
	}
	
	public Funcionario(String cpf, String nome, double salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}

	public Funcionario(double salario) {
		this.salario = salario;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getBonus() {
		return getSalario() * 0.1;
	}
}
