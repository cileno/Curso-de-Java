package br.com.buritech.curso.jse.cap07;

public class Triangulo extends PoligonoGenerico {
	private final static String NOME = "Triangulo";
	private final static int LADOS = 3;
	
	private int[] lados = new int[LADOS];

	public Triangulo(int ladoA, int ladoB, int ladoC) {
		super(NOME, LADOS);
		
		lados[0] = ladoA;
		lados[1] = ladoB;
		lados[2] = ladoC;	
		
		preencherTamanhoDosLados();
	}
	
	@Override
	public double calcularArea() {
		double area = 0;
		
		int ladoA = this.getTamanhoLados()[0];
		int ladoB = this.getTamanhoLados()[1];
		int ladoC = this.getTamanhoLados()[2];
		
		// utilizando a formula de Heron:
		// A = raizQuardada(semiPerimetro * (semiPerimetro - ladoA) *
		// (semiPerimetro - ladoB) - (semiPerimetro - ladoC))
		if(ladoC > 0){
			double semiPer = this.calcularPerimetro(this.getTamanhoLados()) / 2;
			area = Math.sqrt(semiPer * (semiPer - ladoA) * (semiPer - ladoB) * (semiPer - ladoC));
		} else {
			area = (ladoA * ladoB) / 2; //ladoA e ladoB corresponde a base e altura.
		}

		return area;
	}

	@Override
	public void preencherTamanhoDosLados() {
		this.setTamanhoLados(lados);
	}

}
