/*
 * 	Classe que estende a JOptionPane com a intesão de diminuir 
 * a tamanho da linha de código
 */
package br.com.buritech.curso.jse.utils;

import javax.swing.JOptionPane;

public class ShowIO extends JOptionPane {
	// exibe mensagem pedindo um valor e devolvê-o como string
	public static String input(String message) {
		return JOptionPane.showInputDialog(message);
	}

	// converte uma string em inteiro
	public static int strToInt(String message) {
		return Integer.parseInt(input(message));
	}

	// converte uma string em double
	public static double strToDouble(String message) {
		return Double.parseDouble(input(message));
	}
	
	//mostra mensagem
	public static void showMensage(String message){
		JOptionPane.showMessageDialog(null,	message);
	}
}
