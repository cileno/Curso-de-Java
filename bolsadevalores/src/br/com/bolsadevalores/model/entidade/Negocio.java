package br.com.bolsadevalores.model.entidade;

import java.util.Calendar;

public final class Negocio {
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negocio(double preco, int quantidade, Calendar data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public Calendar getData() {
		return data;
	}
	
	//método que retorna o volume
	public double getVolume(){
		return preco * quantidade;
	}
}
