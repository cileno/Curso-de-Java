package br.com.buritech.curso.jse.cap03;

import javax.swing.JOptionPane;

public class SomaMatriz {

	public static void main(String[] args) {
		int tam = 2;
		int[][] matrizA = new int[tam][tam];
		int[][] matrizB = new int[tam][tam];
		int[][] matrizC = new int[tam][tam];

		// lendo conteúdo da matriz A
		for (int lin = 0, linV = 1; lin < tam; lin++) {
			for (int col = 0, colV = 1; col < tam; col++) {
				matrizA[lin][col] = Integer.parseInt(JOptionPane
						.showInputDialog("Valor da posição A" + (linV)
								+ (colV++) + ": "));
			}
			linV++;
		}

		// lendo conteúdo da matriz B
		for (int lin = 0, linV = 1; lin < tam; lin++) {
			for (int col = 0, colV = 1; col < tam; col++) {
				matrizB[lin][col] = Integer.parseInt(JOptionPane
						.showInputDialog("Valor da posição B" + (linV)
								+ (colV++) + ": "));
			}
			linV++;
		}

		// somando as matrizes A e B
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				matrizC[lin][col] = matrizA[lin][col] + matrizB[lin][col];
			}
		}

		// Exibindo o conteúdo das matrizes
		String mostraMatrizA = "";
		String mostraMatrizB = "";
		String mostraMatrizC = "";
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				mostraMatrizA += (matrizA[lin][col] + " ");
				mostraMatrizB += (matrizB[lin][col] + " ");
				mostraMatrizC += (matrizC[lin][col] + " ");
			}
			mostraMatrizA += "\n";
			mostraMatrizB += "\n";
			mostraMatrizC += "\n";
		}
		JOptionPane.showMessageDialog(null, "Matriz A\n" + mostraMatrizA.trim()
				+ "\nMatriz B\n" + mostraMatrizB.trim() + "\nMatriz C\n"
				+ mostraMatrizC.trim());
	}

}
