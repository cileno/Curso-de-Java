package br.com.buritech.curso.jse.cap07;

public class Quadrado extends PoligonoGenerico {

	public Quadrado(String nome, int numeroDeLados, int lado) {
		super(nome, numeroDeLados);
		
		int[] lados = new int[numeroDeLados];
		for(int x = 0; x < this.getNumeroDeLados(); x++){
			lados[x] = lado;
		}
		
		this.setTamanhoLados(lados);
	}

	@Override
	public double calcularArea(int[] tamanhoLados) {
		return tamanhoLados[0] * tamanhoLados[0];
	}
}
