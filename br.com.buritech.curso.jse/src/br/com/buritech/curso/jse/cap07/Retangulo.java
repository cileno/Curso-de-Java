package br.com.buritech.curso.jse.cap07;

public class Retangulo extends PoligonoGenerico {	


	public Retangulo(String nome, int numeroDeLados, int base, int altura) {
		super(nome, numeroDeLados);

		int[] lados = new int[numeroDeLados];
		for(int x = 0; x < this.getNumeroDeLados(); x++){
			if((x % 2) == 0)
				lados[x] = altura;
			else
				lados[x] = base;
		}
		
		this.setTamanhoLados(lados);
	}

	@Override
	public double calcularArea(int[] tamanhoLados) {
		//área = base * altura
		return tamanhoLados[0] * tamanhoLados[1];
	}
}
