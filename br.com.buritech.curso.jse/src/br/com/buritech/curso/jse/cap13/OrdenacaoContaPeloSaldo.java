package br.com.buritech.curso.jse.cap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.buritech.curso.jse.cap06.Conta;

public class OrdenacaoContaPeloSaldo {

	public static void main(String[] args) {
		List<Conta> listaDeContas = new ArrayList<Conta>();
		
		Conta c1 = new Conta(500);
		listaDeContas.add(c1);
		
		Conta c2 = new Conta(100);
		listaDeContas.add(c2);
		
		Conta c3 = new Conta(400);
		listaDeContas.add(c3);
		
		System.out.println("Lista inicial");
		System.out.println(listaDeContas);
		
		Collections.sort(listaDeContas);
		System.out.println("Lista Ordenada");
		System.out.println(listaDeContas);
	}

}
