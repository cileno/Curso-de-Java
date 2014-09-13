package br.com.buritech.curso.jse.cap04.view;

import br.com.buritech.curso.jse.cap04.ContaBancaria;

public class SacaEDeposita {

	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria(1000);
		System.out.println("Saldo: " + conta.getSaldo());
		conta.sacar(200);
		System.out.println("Saldo: " + conta.getSaldo());		
		conta.depositar(500);
		System.out.println("Saldo: " + conta.getSaldo());
	}

}
