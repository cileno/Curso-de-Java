package br.com.buritech.curso.jse.cap07;

public class Retangulo extends PoligonosGenericos {
	private int altura;
	private int comprimento;
	
	public Retangulo(String nome, int comprimento, int altura) {
		super(nome);
		super.setNumeroDeLados(4);

		this.comprimento = comprimento;
		this.altura = altura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	@Override
	public void calcularArea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirDados() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcularPerimetro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarDados() {
		// TODO Auto-generated method stub
		
	}
}
