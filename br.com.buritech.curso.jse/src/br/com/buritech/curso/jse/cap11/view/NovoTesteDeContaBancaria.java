package br.com.buritech.curso.jse.cap11.view;

import exercicio.model.Conta;

public class NovoTesteDeContaBancaria {

	public static void main(String[] args) {
		Conta c1 = new Conta(300);
		System.out.println("Conta c1 - " + c1);
		String testeSTR = "será?";
		System.out.println("TesteSTR: " + c1.equals(testeSTR));
		
		Conta c2 = new Conta(300);
		
		System.out.println("Conta c2 - " + c2);
		System.out.println("TesteConta: " + c1.equals(c2));
	}

}
