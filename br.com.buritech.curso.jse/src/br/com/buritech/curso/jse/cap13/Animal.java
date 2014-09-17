package br.com.buritech.curso.jse.cap13;

public class Animal implements Comparable<Animal> {
	private int codigo;
	private String nome;

	public Animal(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return codigo + " - " + nome;
	}

	@Override
	public int compareTo(Animal animal) {
		if (this.codigo > animal.codigo) {
			return 1;
		} else if (this.codigo < animal.codigo) {
			return -1;
		}

		return 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
