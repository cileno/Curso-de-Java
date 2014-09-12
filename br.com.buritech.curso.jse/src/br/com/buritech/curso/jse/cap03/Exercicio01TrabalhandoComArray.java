package br.com.buritech.curso.jse.cap03;

import javax.swing.JOptionPane;

public class Exercicio01TrabalhandoComArray {

	public static void main(String[] args) {
		System.out.println("Início do Programa");

		int tamArray = Integer.parseInt(JOptionPane
				.showInputDialog("Tamanho do VETOR"));

		int[] vetor = new int[tamArray];

		int soma = 0;

		double media = 0.0;

		String exibeValores = "";

		// adicionando valores ao vetor e realizando os cálculos
		for (int i = 0, e = 1; i < vetor.length; i++) {
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Valor do "
					+ (e++) + "º elemento"));

			exibeValores += (vetor[i] + " ");

			soma += vetor[i];
		}

		media = soma / vetor.length;

		// mostrando os resultados
		JOptionPane.showMessageDialog(null, "Dados referentes ao vetor:\n"
				+ "Tamanho do Vetor: " + vetor.length
				+ "\nValores inseridos no Vetor: " + exibeValores.trim()
				+ "\nSoma dos Valores: " + soma + "\nMédia dos Valores: "
				+ media);
	}

}
