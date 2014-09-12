package br.com.buritech.curso.jse.cap06;

public class ControleBonus {
	private double total;

	public double getTotal() {
		return total;
	}
	
	public void soma(Funcionario f) {
		this.total += f.getBonus();
	}
}
