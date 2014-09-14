package br.com.buritech.curso.jse.cap04.view;

import br.com.buritech.curso.jse.cap04.ContaBancaria;
import br.com.buritech.curso.jse.utils.ShowIO;

public class Operacao {
	public static void main(String[] args) {
		ContaBancaria c1 = new ContaBancaria();
		ContaBancaria c2 = new ContaBancaria();
		
		c1.depositar(100);
		
		ShowIO.showMensage("Saldo Atual: "+c1.getSaldo());
		
		if (c1.sacar(150))
			ShowIO.showMensage("Saque realizado com sucesso");
		else
			ShowIO.showMensage("Saldo Insuficiente");;
		
		if(c1.transferir(c2, 200))
			ShowIO.showMensage("Transferencia realizada com sucesso");
		else
			ShowIO.showMensage("Saldo Insuficiente");
	}
}
