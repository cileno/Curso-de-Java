package br.com.buritech.curso.jse.cap06.app;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jse.cap06.Agenda;

public class AgendaTeste {

	public static void main(String[] args) {
		int limiteAgenda = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade de contatos da Agenda"));
		
		Agenda agenda = new Agenda(limiteAgenda);
		
		System.out.println("A agenda reservou espaço para:\n"
				+ "Quantidade de Amigos: " + agenda.getTotalAmigos() + "\n"
				+ "Quantidade de Conhecidos: " + agenda.getTotalConhecidos() + "\n");
		
		agenda.addInformacoes();
		
		agenda.imprimeAniversarios();
		agenda.imprimeEmail();
	}

}
