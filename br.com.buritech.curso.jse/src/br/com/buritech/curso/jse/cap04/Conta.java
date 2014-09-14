package br.com.buritech.curso.jse.cap04;


public class Conta {
	private String numero;
	private double saldo;
	private double limite;
	
	private Cliente titular;

	public Conta() {

	}

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public String getNumeroConta() {
		return numero;
	}

	public void setNumeroConta(String numeroConta) {
		this.numero = numeroConta;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public boolean sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}

		return false;
	}

	public void depositar(double valor) {
		if (valor > 0)
			this.saldo += valor;
	}

	public boolean transferir(ContaBancaria destino, double valor) {
		if(sacar(valor)){
			destino.depositar(valor);
			return true;
		}
		return false;
	}
}
