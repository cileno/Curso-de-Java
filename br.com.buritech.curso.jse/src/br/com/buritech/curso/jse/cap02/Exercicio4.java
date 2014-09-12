package br.com.buritech.curso.jse.cap02;

import javax.swing.JOptionPane;

public class Exercicio4 {
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Nome:");
		JOptionPane.showMessageDialog(null, "Nome Informado: " + nome);
		
		System.exit(0);
	}
}
