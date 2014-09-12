package br.com.buritech.curso.jse.cap02;

import javax.swing.JOptionPane;

public class CineGrandeZe {
	public static void main(String[] args) {
		int censura = 14;
			
		String nome = JOptionPane.showInputDialog("Nome:");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
		int classificacao = Integer.parseInt(JOptionPane.showInputDialog("Classificação"));
		
		System.out.print(nome + " possui " + idade + " ");
		if(classificacao > censura)
			System.out.println("e está liberado para assistir o filme em cartaz.");
		else
			System.out.println("e NÃO está liberado para assistir o filme em cartaz");
	}
}
