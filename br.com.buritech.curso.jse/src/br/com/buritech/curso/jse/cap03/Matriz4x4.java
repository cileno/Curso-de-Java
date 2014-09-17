package br.com.buritech.curso.jse.cap03;

import javax.swing.JOptionPane;

public class Matriz4x4 {

	public static void main(String[] args) {
		int tam = 4;
		double[][] matriz = new double[tam][tam];

		// calculando os valores
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				matriz[lin][col] = lin * col;
			}
		}

		// imprime a matriz
		String resultado = "MATRIZ 4x4\n";
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				matriz[lin][col] = lin * col;
				resultado += (matriz[lin][col] + " ");
			}
			resultado += "\n";
		}
		
		JOptionPane.showMessageDialog(null, resultado);
	}

}
