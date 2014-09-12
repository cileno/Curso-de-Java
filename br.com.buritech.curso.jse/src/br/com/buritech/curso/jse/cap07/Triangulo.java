package br.com.buritech.curso.jse.cap07;

public class Triangulo extends PoligonoGenerico {

	public Triangulo(String nome, int numeroDeLados, int[] lados) {
		super(nome, numeroDeLados);
		
		this.setTamanhoLados(lados);
	}
	
		@Override
	public int calcularPerimetro(int[] tamanhoLados) {
		return (super.calcularPerimetro(tamanhoLados)/2);
	}



	@Override
	public double calcularArea(int[] tamanhoLados) {
		//fórmula de Heron
		int p = this.calcularPerimetro(tamanhoLados);
		
		int a = tamanhoLados[0];
		int b = tamanhoLados[1];
		int c = tamanhoLados[2];
		
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
}
