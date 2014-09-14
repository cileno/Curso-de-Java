package br.com.buritech.curso.jse.cap06.view;

import br.com.buritech.curso.jse.cap06.Gerente;

public class TestaGerente {

	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		
		gerente.setNome("João da Silva");
		gerente.setSenha(4231);
		
		System.out.println(gerente.getNome());
		System.out.println(gerente.getSenha());
	}

}
