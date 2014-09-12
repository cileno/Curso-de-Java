package br.com.buritech.curso.jse.cap06;

public class Pessoa {
	private String nome;
	private int idade;
	
	//constructors
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa() {
		this.nome = "Indefinido";
		this.idade = 0;
	}

	//GETs and SETs
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
