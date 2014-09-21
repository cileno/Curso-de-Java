package br.com.buritech.curso.jse.cap07;

import java.util.Calendar;

public abstract class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	
	private int matricula;

	public Funcionario(double salario) {
		//Calendar dataAtual = Calendar.getInstance();
		this.salario = salario;
		
		this.matricula = (int) Math.random() * Calendar.YEAR;
	}

	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		
		this.matricula = (int) Math.random() * Calendar.YEAR;
	}

	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
		
		this.matricula = (int) Math.random() * Calendar.YEAR;
	}

	public Funcionario(String nome) {
		this.nome = nome;
		
		this.matricula = (int) Math.random() * Calendar.YEAR;
	}
	
	public Funcionario() {
		this.matricula = (int) Math.random() * Calendar.YEAR;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public abstract double getBonus();

	public int getMatricula() {
		return matricula;
	}
}
