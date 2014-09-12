package br.com.buritech.curso.jse.cap07;


public abstract class PoligonosGenericos {
	private String nome;
	private int numeroDeLados;
	private int[] tamanhoLados;
	
	public PoligonosGenericos(String nome, int numeroDeLados) {
		this.nome = nome;
		this.numeroDeLados = numeroDeLados;
		
		this.tamanhoLados = new int[this.numeroDeLados];
		
		for(int x = 0; x < this.numeroDeLados; x++)
			this.tamanhoLados[x] = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumeroDeLados() {
		return numeroDeLados;
	}
	
	public void setNumeroDeLados(int numeroDeLados) {
		this.numeroDeLados = numeroDeLados;
	}
	
	public int[] getTamanhoLados() {
		return tamanhoLados;
	}

	public void setTamanhoLados(int[] tamanhoLados) {
		this.tamanhoLados = tamanhoLados;
	}

	public abstract int calcularArea(int[] tamanhoLados);
	
	public abstract void imprimirDados();
	
	public abstract int calcularPerimetro(int[] tamanhoLados);
	
	public abstract void alterarDados(String nome, int numeroDeLados, int[] tamanhoLados);
}
