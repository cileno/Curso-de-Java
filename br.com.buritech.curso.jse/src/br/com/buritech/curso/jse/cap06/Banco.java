package br.com.buritech.curso.jse.cap06;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void adicionar(Conta conta){
		contas.add(conta);
	}
	
	public Conta pegarConta(int x) {
		return contas.get(x);
	}
	
	public int pegarTotalDeContas() {
		return contas.size();
	}
}
