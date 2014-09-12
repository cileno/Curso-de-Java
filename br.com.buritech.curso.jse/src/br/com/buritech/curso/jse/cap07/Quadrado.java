package br.com.buritech.curso.jse.cap07;

public class Quadrado extends PoligonosGenericos {

	public Quadrado(String nome, int numeroDeLados) {
		super(nome, numeroDeLados);
	}

	@Override
	public int calcularArea(int[] tamanhoLados) {
		//return getLado() * getLado()
		return 0;
	}

	@Override
	public int calcularPerimetro(int[] tamanhoLados) {
		// getLado() * getNumeroDeLados();
		return 0;
	}

	@Override
	public void alterarDados(String nome, int numeroDeLados, int[] tamanhoLados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirDados() {
		//System.out.println(getNome() + ", " + getNumeroDeLados() + ", " + getLado());	
	}
}
