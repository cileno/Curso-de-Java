package br.com.buritech.curso.jse.cap07;

public class Triangulo extends PoligonosGenericos {
	private int ladoA;
	private int ladoB;
	private int ladoC;

	public Triangulo(String nome, int ladoA, int ladoB, int ladoC) {
		super(nome);
		
		super.setNumeroDeLados(3);
		
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	public int getLadoA() {
		return ladoA;
	}

	public void setLadoA(int ladoA) {
		this.ladoA = ladoA;
	}

	public int getLadoB() {
		return ladoB;
	}

	public void setLadoB(int ladoB) {
		this.ladoB = ladoB;
	}

	public int getLadoC() {
		return ladoC;
	}

	public void setLadoC(int ladoC) {
		this.ladoC = ladoC;
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
