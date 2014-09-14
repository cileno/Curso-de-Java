package br.com.buritech.curso.jse.cap06.view;

import br.com.buritech.curso.jse.cap06.*;

public class TestaBonusFuncionarios {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		f.setSalario(1300);
		
		Gerente g = new Gerente();
		g.setSalario(5000);
		
		Funcionario fGerente = new Gerente(5000);
		
		System.out.println("Bônus de Funcionário: " + f.getBonus());
		System.out.println("Bônus de Gerente: " + g.getBonus());
		System.out.println("Bônus do Funcionário Gerente: " + fGerente.getBonus());
	}

}
