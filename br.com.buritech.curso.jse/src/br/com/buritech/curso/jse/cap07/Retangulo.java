package br.com.buritech.curso.jse.cap07;

public class Retangulo extends PoligonoGenerico {
	private final static String NOME = "Retangulo";
	private final static int LADOS = 4;

	private int base;
	private int altura;
	

	public Retangulo(int base, int altura) {
		super(NOME, LADOS);
		
		this.altura = altura;
		this.base = base;
		
		preencherTamanhoDosLados();
	}

	@Override
	public double calcularArea() {
		return (this.base * this.altura)/2;
	}

	@Override
	public void preencherTamanhoDosLados() {
		int[] lados = new int[LADOS];

		for (int x = 0; x < LADOS; x++) {
			if((x % 2) == 0)
				lados[x] = this.base;
			else
				lados[x] = this.altura;
		}

		this.setTamanhoLados(lados);
	}
}
