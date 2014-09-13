package br.com.buritech.curso.jse.cap07;

public class Quadrado extends PoligonoGenerico {
	private final static String NOME = "Quadrado";
	private final static int LADOS = 4;

	private int lado;

	public Quadrado(int lado) {
		super(NOME, LADOS);
		
		this.lado = lado;
		
		preencherTamanhoDosLados();
	}

	@Override
	public double calcularArea() {
		return this.lado * this.lado;
	}

	@Override
	public void preencherTamanhoDosLados() {
		int[] lados = new int[LADOS];

		for (int x = 0; x < LADOS; x++) {
			lados[x] = this.lado;
		}
		
		this.setTamanhoLados(lados);
	}
}
