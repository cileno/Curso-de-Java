package br.com.buritech.curso.jse.cap06;

public class Conta {
	private String numero;
	private double saldo;

	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public boolean sacar(double valor){
		if ((getSaldo() >= valor) && (valor >= 0.0)) {
			this.saldo -= valor;
			
			return true;
		}
		
		return false;
	}
	
	public void atualizarConta(double taxa) {
		this.saldo += (getSaldo() * taxa);
	}
}
