package br.com.buritech.curso.jse.cap07;


public abstract class PoligonoGenerico {
	private String nome;
	private int numeroDeLados;
	private int[] tamanhoLados;
	
	public PoligonoGenerico(String nome, int numeroDeLados) {
		this.nome = nome;
		this.numeroDeLados = numeroDeLados;
		
		this.tamanhoLados = new int[this.numeroDeLados];
		
		for(int x = 0; x < this.numeroDeLados; x++)
			this.tamanhoLados[x] = 0;
	}
	
	@Override
	public String toString() {
		//coletando os tamanhos dos lados do polígono
		String medidaDosLados = "";
		for(int x = 0; x < getNumeroDeLados(); x++){
			medidaDosLados += getTamanhoLados()[x] + " ";
		}
		
		//juntando todos os dados
		String mostra = "Polígono: " + getNome() + " [" + getNumeroDeLados() + "]\n"
				+ "\tMedida dos lados: " + medidaDosLados + "\n"
				+ "\tÁrea: " + calcularArea(tamanhoLados) + "\n"
				+ "\tPerimetro: " + calcularPerimetro(tamanhoLados);

		return mostra;
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

	public abstract double calcularArea(int[] tamanhoLados);
	
	public int calcularPerimetro(int[] tamanhoLados){
		int soma = 0;
		for(int x = 0; x < this.getNumeroDeLados(); x++){
			soma += tamanhoLados[x];
		}
		return soma;
	}
	
	public void alterarDados(String nome, int numeroDeLados, int[] tamanhoLados){
		this.setNome(nome);
		this.setNumeroDeLados(numeroDeLados);
		this.setTamanhoLados(tamanhoLados);

	}
}
