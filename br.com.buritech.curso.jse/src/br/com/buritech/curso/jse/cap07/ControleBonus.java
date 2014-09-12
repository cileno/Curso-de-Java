package br.com.buritech.curso.jse.cap07;

public class ControleBonus {
	private double totalDeBonus = 0;

	public void registrarBonus(Funcionario funcionario) {
		System.out.println("Registrando a bonifica��o do funcion�rio: "
				+ funcionario);

		totalDeBonus += funcionario.getBonus();
	}

	public double getTotalDeBonus() {
		return this.totalDeBonus;
	}
}
