package br.com.buritech.curso.jse.cap06.view;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jse.cap06.Banco;
import br.com.buritech.curso.jse.cap06.Conta;
import br.com.buritech.curso.jse.cap06.ContaCorrente;
import br.com.buritech.curso.jse.cap06.ContaPoupanca;

public class TestaBanco {

	public static void main(String[] args) {
		Banco bank = new Banco();

		Conta conta = null;
		
		int segueAdicionando = JOptionPane.YES_OPTION;
		
		do {
			int tipoContaCorrente = JOptionPane.showConfirmDialog(null, "É Conta Corrente?", "Pergunta",JOptionPane.YES_NO_OPTION);
			String numeroConta = JOptionPane.showInputDialog("Informe o número da conta");
			double saldoConta = Double.parseDouble(JOptionPane.showInputDialog("Informe o saldo"));
			
			if (tipoContaCorrente == JOptionPane.YES_OPTION)
				conta = new ContaCorrente(numeroConta, saldoConta);
			else
				conta = new ContaPoupanca(numeroConta, saldoConta);

			bank.adicionar(conta);
			
			segueAdicionando = JOptionPane.showConfirmDialog(null, "Adiciona Conta?", "Confirmação",JOptionPane.YES_NO_OPTION);
		} while (segueAdicionando == JOptionPane.YES_OPTION);
		
		for(int x = 0; x < bank.pegarTotalDeContas(); x++){
			System.out.println("Número da Conta: " + bank.pegarConta(x).getNumero());
			System.out.println("Saldo da Conta: " + bank.pegarConta(x).getSaldo());
		}
	}

}
